package simplecalmeacc;

import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class simplememo extends JPanel{
    
        private static final long serialVersionUID = 1L;
        private JButton jBtnAddRow = null;
        private JButton jBtnDelRow = null;
        private JTable table;
        private JScrollPane scrollPane;

        public simplememo() {
            setLayout(null);
            String colNames[] = {"��¥","����"};
            DefaultTableModel model = new DefaultTableModel(colNames, 0);
            table = new JTable(model);
            table.addMouseListener(new JTableMouseListener());
            scrollPane = new JScrollPane(table);            // ���̺� ��ũ�� ����� �ϱ�
            scrollPane.setSize(500, 200);
            add(scrollPane);        
            initialize();    
        }

        private class JTableMouseListener implements MouseListener{
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                
                JTable jtable = (JTable)e.getSource();
                int row = jtable.getSelectedRow();
                int col = jtable.getSelectedColumn();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                System.out.println(model.getValueAt(row, 0));   // ������ ���� �κп��� 0��° ���� ��� 
                System.out.println(model.getValueAt(row, col));   // ������ ��� ���� �ش��ϴ� ���õ� ������ �ϳ� ���
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {    
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }
        }
        
        private void initialize() {
            // ���̺� ���� ���� �߰��ϴ� �κ�
            jBtnAddRow = new JButton();
            jBtnAddRow.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBtnAddRow();
                }
            });
            jBtnAddRow.setBounds(100,222,120, 25);
            jBtnAddRow.setText("�߰�");
            add(jBtnAddRow);
            
            // ���õ� ���̺� ���� �����ϴ� �κ�
            jBtnDelRow = new JButton();
            jBtnDelRow.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jBtnDelRow();
                }
            });
            jBtnDelRow.setBounds(new Rectangle(250, 222, 120, 25));
            jBtnDelRow.setText("����");
            add(jBtnDelRow);
        }

        void jBtnAddRow(){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(new String[]{"",""});            // �����̺��� �ʱⰪ
        }

        void jBtnDelRow(){
            int row = table.getSelectedRow();
            if(row<0) return; // ������ �ȵ� ���¸� -1����
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            //System.out.println(model.getValueAt(row, 0));
            model.removeRow(row);
        }


    public static void main(String[] args) {
        
    	simplememo panel = new simplememo();
        JFrame win = new JFrame();
        win.add(panel);
        win.setSize(510,300);
        win.setVisible(true);
    }
}