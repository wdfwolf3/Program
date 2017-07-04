package program.win;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotKeyDialog {
    private Display display;
    private Shell shell;
    private String filename = "save.txt";
    private Table table;
    private CheckboxTableViewer tv;
    private List<KeyEntity> list = new ArrayList<>();
    private KeyBoardHook hook;
    private Thread thread;

    synchronized boolean open() {
        display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
//        hook = new KeyBoardHook();
//        thread = new Thread(hook);
//        thread.start();
//        try {
//            thread.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.notify();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
//        hook.unhook();
        write();
        return true;
    }

    /**
     * Create contents of the window.
     */
    private void createContents() {
        shell = new Shell();
        shell.setSize(380, 500);
        shell.setText("HotKey");
        shell.setImage(new Image(display, "D:\\temp\\lpl.jpg"));
        shell.setLayout(new GridLayout(1, false));

        Composite composite = new Composite(shell, SWT.NONE);
        GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_composite.widthHint = 379;
        gd_composite.heightHint = 449;
        composite.setLayoutData(gd_composite);
        composite.setLayout(new GridLayout(3, false));

        Button addButton = new Button(composite, SWT.NONE);
        addButton.setText("Add");
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                AddOrEditKeyDialog dialog = new AddOrEditKeyDialog(composite.getShell(), "add", new KeyEntity("", "",0), thread);
                if (dialog.open() == Window.OK){
                    list.add(dialog.getKey());
                    tv.setInput(list);
//                    setNumber();
                }
            }
        });

        Button editButton = new Button(composite, SWT.NONE);
        editButton.setText("Edit");
        editButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection select = (StructuredSelection) tv.getSelection();
                Object object = select.getFirstElement();
                if (object instanceof KeyEntity){
                    AddOrEditKeyDialog dialog = new AddOrEditKeyDialog(composite.getShell(), "edit", (KeyEntity) object, null);
                    dialog.open();
                    tv.setInput(list);
//                    setNumber();
                }
            }
        });

        Button deleteButton = new Button(composite, SWT.NONE);
        deleteButton.setText("Delete");
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MessageDialog.openConfirm(composite.getShell(), "提示", "是否删除选中快捷键？")){
                    deleteKey();
                }
            }
        });

        table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION|SWT.SINGLE);
        GridData tableGridData = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1);
        tableGridData.widthHint = 325;
        tableGridData.heightHint = 390;
        table.setLayoutData(tableGridData);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        String[] str = new String[]{"快捷键", "文本", "启用/禁用"};
        for (int i = 0; i < str.length; i++) {
            TableColumn column = new TableColumn(table, SWT.CENTER);
            column.setText(str[i]);
            if (i == 0) {
                column.setWidth(50);
            } else if (i == 1) {
                column.setWidth(215);
            } else {
                column.setWidth(75);
            }
        }
        table.redraw();
        tv = new CheckboxTableViewer(table);
        tv.setContentProvider(new ContentProvider());
        tv.setLabelProvider(new HotKeyDialogProvider());
        tv.setColumnProperties(HotKeyCellModifier.PROP_NAME);
        CellEditor[] editors = new CellEditor[3];
        String[] comboNames = {"F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12"};
        String[] comboUse = {"启动", "禁用"};
        editors[0] = new ComboBoxCellEditor(table, comboNames, SWT.READ_ONLY);
        editors[2] = new ComboBoxCellEditor(tv.getTable(), comboUse, SWT.READ_ONLY);
        tv.setCellModifier(new HotKeyCellModifier(tv));
        tv.setCellEditors(editors);
        tv.setInput(read());
//        setNumber();
    }

    private List<KeyEntity> read(){
        File file = new File("D:\\temp\\save.txt");
        String string;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((string = bufferedReader.readLine())!=null){
                String[] strings = string.trim().split(" ");
                KeyEntity keyEntity = new KeyEntity(strings[0], strings[1], Integer.parseInt(strings[2]));
                list.add(keyEntity);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void write(){
        StringBuilder stringBuilder = new StringBuilder("");
        File file = new File("D:\\temp\\save.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (KeyEntity keyEntity : list){
                stringBuilder.append(keyEntity.getName()).append(" ").append(keyEntity.getValue()).append(" ").append(String.valueOf(keyEntity.getFlag())).append("\n");
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setNumber(){
        TableItem[] items = table.getItems();
        if (items != null && items.length > 0) {
            int startNo = 1;
            for (TableItem item : items) {
                item.setText(String.valueOf(startNo));
                startNo = startNo + 1;
            }
        }
    }

    private void deleteKey(){
        StructuredSelection select = (StructuredSelection) tv.getSelection();
        Object object = select.getFirstElement();
        if (object instanceof KeyEntity){
            KeyEntity keyEntity = (KeyEntity) object;
            list.remove(keyEntity);
            tv.setInput(list);
//            setNumber();
        }
    }
}

class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof List) {
            return ((List) inputElement).toArray();
        } else {
            return new Object[0];
        }
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}

class HotKeyDialogProvider extends LabelProvider implements ITableLabelProvider {

    @Override
    public Image getColumnImage(Object o, int i) {
        return null;
    }

    @Override
    public String getColumnText(Object o, int i) {
        KeyEntity keyEntity = (KeyEntity) o;
        if (i == 0) {
            return keyEntity.getName();
        } else if (i == 1) {
            return keyEntity.getValue();
        } else if (i == 2) {
            return keyEntity.getFlag() == 0 ? "启用" : "禁用";
        }
        return "";
    }
}

class HotKeyCellModifier implements ICellModifier {
    final static String[] PROP_NAME = {"name", "value", "isUsed"};
    private CheckboxTableViewer tableViewer;

    HotKeyCellModifier(CheckboxTableViewer tableViewer) {
        this.tableViewer = tableViewer;
    }

    @Override
    public boolean canModify(Object o, String s) {
        return s.equals(PROP_NAME[2]) || s.equals(PROP_NAME[0]);
    }

    @Override
    public Object getValue(Object o, String s) {
        if (o instanceof KeyEntity) {
            KeyEntity keyEntity = (KeyEntity) o;
            if (PROP_NAME[2].equals(s)) {
                return keyEntity.getFlag();
            }else if (PROP_NAME[0].equals(s)){
                return Integer.parseInt(keyEntity.getName().substring(keyEntity.getName().indexOf('F')+1))-1;
            }
        }
        return null;
    }

    @Override
    public void modify(Object o, String s, Object o1) {
        TableItem item = (TableItem) o;
        if (item.getData() instanceof KeyEntity) {
            KeyEntity keyEntity = (KeyEntity) item.getData();
            if (PROP_NAME[2].equals(s)) {
                keyEntity.setFlag((Integer) o1);
            }else if (PROP_NAME[0].equals(s)){
                keyEntity.setName("F" + ((Integer)o1+1));
            }
            tableViewer.update(keyEntity, null);
        }
    }
}
