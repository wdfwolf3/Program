package program.win;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by wdfwolf3 on 2017/6/26.
 */
public class AddOrEditKeyDialog extends Dialog {
    private boolean isAdd;
    private String sign;
    private KeyEntity key;
    private Text nameText;
    private Text valueText;

    public AddOrEditKeyDialog(Shell parent, String sign, KeyEntity key, Thread thread) {
        super(parent);
        isAdd = "add".equals(sign);
        this.sign = sign;
        this.key = key;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(sign);
    }

    @Override
    protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
        label = id == IDialogConstants.OK_ID ? "确定" : "取消";
        Button btn = super.createButton(parent, id, label, defaultButton);
        return btn;
    }

    @Override
    protected Point getInitialSize() {
        return new Point(400, 200);
    }

    @Override
    protected Control createDialogArea(Composite com) {
        Composite area = (Composite) super.createDialogArea(com);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1,1));
//        composite.setBackground(com.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        GridLayout layout = new GridLayout(2,false);
//        layout.marginTop=6;
//        layout.marginLeft=7;
//        layout.marginRight=7;
//        layout.marginBottom=11;
        composite.setLayout(layout);

        GridData gridlb=new GridData(SWT.LEFT, SWT.CENTER, false,false, 1, 1);
        gridlb.widthHint = 30;
        GridData gridtxt=new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gridtxt.widthHint = 150;


        Label nameLabel = new Label(composite, SWT.NONE);
        nameLabel.setText("key");
        nameLabel.setLayoutData(gridlb);
        nameText = new Text(composite, SWT.BORDER);
        nameText.setLayoutData(gridtxt);
        nameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("abc");
            }
        });

        Label lbVar = new Label(composite, SWT.NONE);
//        lbVar.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
        lbVar.setText("type");
        lbVar.setLayoutData(gridlb);
        valueText =new Text(composite,SWT.BORDER);
//        txtVar.setTextLimit(400);
        valueText.setLayoutData(gridtxt);
        nameText.setText(key.getName());
        valueText.setText(key.getValue());
        return com;
    }

    @Override
    protected void okPressed() {
        key.setName(nameText.getText()==null?"":nameText.getText());
        key.setValue(valueText.getText()==null?"":valueText.getText());
        super.okPressed();
    }

    @Override
    protected void cancelPressed() {
        super.cancelPressed();
    }

    public KeyEntity getKey() {
        return key;
    }
}
