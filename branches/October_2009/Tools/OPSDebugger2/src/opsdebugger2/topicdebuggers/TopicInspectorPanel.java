/*
 * TopicInspectorPanel.java
 *
 * Created on den 12 oktober 2007, 08:30
 */
package opsdebugger2.topicdebuggers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import ops.KeyFilterQoSPolicy;
import ops.MessageFilter;
import ops.OPSObject;
import ops.Subscriber;
import ops.Topic;

/**
 *
 * @author  angr
 */
public class TopicInspectorPanel extends javax.swing.JPanel implements Observer
{

    public Observable closeEvent = new CloseEvent();
    private Subscriber subscriber;
    private KeyFilterQoSPolicy keyFilter;
    private DefaultComboBoxModel availableKeysComboModel;
    private PublisherMessageFilter publisherFilter;
    private DefaultComboBoxModel availablePublishersComboModel;
    private TopicTableView tableView;

    /** Creates new form TopicInspectorPanel */
    public TopicInspectorPanel(Subscriber sub, String name)
    {
        setName(name);


        subscriber = sub;
        //subscriber.start();


        initComponents();
        availableKeysComboModel = new DefaultComboBoxModel();
        availableKeysComboBox.setModel(availableKeysComboModel);
        availableKeysComboModel.addElement("");

        availablePublishersComboModel = new DefaultComboBoxModel();
        availablePublishersComboBox.setModel(availablePublishersComboModel);
        availablePublishersComboModel.addElement("");




        topicNameLabel.setText(name);
        tableView = new TopicTableView(getSubscriber());
        tabbedPane1.add("Table view", tableView);
        subscriber.addObserver(this);
    //tabbedPane1.add("Advanced", new TopicCompositeView(s, (JFrame)getParent()));
    //topicTreeView1.setSubscriber(s);
    }

    public String getTopicName()
    {
        return topicNameLabel.getText();
    }

    public void setTopicName(String s)
    {
        topicNameLabel.setText(s);
    }

    public void setAndApplyKey(String key)
    {
        keyFilterField.setText(key);
        applyKeyFilterButtonActionPerformed(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane1 = new javax.swing.JTabbedPane();
        topicNameLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        keyFilterField = new javax.swing.JTextField();
        applyKeyFilterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        availableKeysComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        publisherFilterField = new javax.swing.JTextField();
        availablePublishersComboBox = new javax.swing.JComboBox();
        applyPublisherFilterButton = new javax.swing.JButton();
        suppressArraysCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        timeBasedFilterTextField = new javax.swing.JTextField();
        timeBasedFilterSetButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Subscriber"));

        topicNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        topicNameLabel.setText("Topic Name");

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opsdebugger2/resources/closebutton.PNG"))); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        keyFilterField.setToolTipText("Put space separated strings with the keys you want to listen to. Empty field indicates no KeyFilter...");

        applyKeyFilterButton.setText("Apply");
        applyKeyFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyKeyFilterButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("KeyFilter");

        availableKeysComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableKeysComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("PublisherFilter");

        publisherFilterField.setToolTipText("Put space separated strings with the keys you want to listen to. Empty field indicates no KeyFilter...");

        availablePublishersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availablePublishersComboBoxActionPerformed(evt);
            }
        });

        applyPublisherFilterButton.setText("Apply");
        applyPublisherFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyPublisherFilterButtonActionPerformed(evt);
            }
        });

        suppressArraysCheckBox.setText("Suppress arrays");
        suppressArraysCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppressArraysCheckBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Time Based Filter");

        timeBasedFilterTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeBasedFilterTextField.setText("0");

        timeBasedFilterSetButton.setText("Set");
        timeBasedFilterSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeBasedFilterSetButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .add(suppressArraysCheckBox)
                    .add(layout.createSequentialGroup()
                        .add(topicNameLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 191, Short.MAX_VALUE)
                        .add(closeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(29, 29, 29)
                        .add(keyFilterField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(availableKeysComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(applyKeyFilterButton))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(publisherFilterField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(availablePublishersComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(applyPublisherFilterButton))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(timeBasedFilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(timeBasedFilterSetButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(closeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, topicNameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(applyKeyFilterButton)
                    .add(availableKeysComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(keyFilterField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(applyPublisherFilterButton)
                    .add(availablePublishersComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(publisherFilterField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(suppressArraysCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(timeBasedFilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(timeBasedFilterSetButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyKeyFilterButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_applyKeyFilterButtonActionPerformed
    {//GEN-HEADEREND:event_applyKeyFilterButtonActionPerformed
// TODO add your handling code here:
        synchronized (this)
        {
            if (keyFilter == null)
            {
                keyFilter = new KeyFilterQoSPolicy();
            }
            String[] strings = keyFilterField.getText().split(" ");
            if (strings.length < 2 && strings[0].equals(""))
            {
                getSubscriber().getFilterQoSPolicies().remove(keyFilter);
            } else
            {
                Vector<String> keys = new Vector<String>();
                for (int i = 0; i < strings.length; i++)
                {
                    keys.add(strings[i]);
                }
                keyFilter.setKeys(keys);
                if (!getSubscriber().getFilterQoSPolicies().contains(keyFilter))
                {
                    getSubscriber().addFilterQoSPolicy(keyFilter);
                }
            }
        }

    }//GEN-LAST:event_applyKeyFilterButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeButtonActionPerformed
    {//GEN-HEADEREND:event_closeButtonActionPerformed
// TODO add your handling code here:

        ((CloseEvent) closeEvent).fireEvent(this);
        setVisible(false);

    }//GEN-LAST:event_closeButtonActionPerformed

private void availableKeysComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableKeysComboBoxActionPerformed
// TODO add your handling code here:
    synchronized (this)
    {
        keyFilterField.setText((String) availableKeysComboModel.getSelectedItem());
    }
}//GEN-LAST:event_availableKeysComboBoxActionPerformed

private void availablePublishersComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_availablePublishersComboBoxActionPerformed
{//GEN-HEADEREND:event_availablePublishersComboBoxActionPerformed
    // TODO add your handling code here:
    synchronized (this)
    {
        publisherFilterField.setText((String) availablePublishersComboModel.getSelectedItem());
    }
}//GEN-LAST:event_availablePublishersComboBoxActionPerformed

private void applyPublisherFilterButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_applyPublisherFilterButtonActionPerformed
{//GEN-HEADEREND:event_applyPublisherFilterButtonActionPerformed

    synchronized (this)
    {

        // TODO add your handling code here:
        if (publisherFilter == null)
        {
            publisherFilter = new PublisherMessageFilter();
        }
        String[] strings = publisherFilterField.getText().split(" ");
        if (strings.length < 2 && strings[0].equals(""))
        {
            getSubscriber().getFilterQoSPolicies().remove(publisherFilter);
        } else
        {
            Vector<String> publishers = new Vector<String>();
            for (int i = 0; i < strings.length; i++)
            {
                publishers.add(strings[i]);
            }
            publisherFilter.setKeys(publishers);
            if (!getSubscriber().getMessageFilters().contains(publisherFilter))
            {
                getSubscriber().addFilter(publisherFilter);
            }
        }
    }
}//GEN-LAST:event_applyPublisherFilterButtonActionPerformed

private void suppressArraysCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_suppressArraysCheckBoxActionPerformed
{//GEN-HEADEREND:event_suppressArraysCheckBoxActionPerformed
    // TODO add your handling code here:
    tableView.setSuppressArrays(suppressArraysCheckBox.isSelected());
}//GEN-LAST:event_suppressArraysCheckBoxActionPerformed

private void timeBasedFilterSetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_timeBasedFilterSetButtonActionPerformed
{//GEN-HEADEREND:event_timeBasedFilterSetButtonActionPerformed
    // TODO add your handling code here:
    tableView.setTimeBasedFilter(Long.parseLong(timeBasedFilterTextField.getText()));
}//GEN-LAST:event_timeBasedFilterSetButtonActionPerformed

    public Subscriber getSubscriber()
    {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber)
    {
        this.subscriber = subscriber;
    }

    private void updateAvailableKeys(String key)
    {
        synchronized (this)
        {
            for (int i = 0; i < availableKeysComboModel.getSize(); i++)
            {
                if (availableKeysComboModel.getElementAt(i).equals(key))
                {
                    return;
                }

            }
            availableKeysComboModel.addElement(key);
        //availableKeysComboBox.updateUI();
        }
    }

    private void updateAvailablePublishers(String pub)
    {
        synchronized (this)
        {

            for (int i = 0; i < availablePublishersComboModel.getSize(); i++)
            {

                if (availablePublishersComboModel.getElementAt(i).equals(pub))
                {
                    return;
                }

            }
            availablePublishersComboModel.addElement(pub);

        //availableKeysComboBox.updateUI();
        }
    }

    class CloseEvent extends Observable
    {

        public void fireEvent(Object o)
        {
            setChanged();
            notifyObservers(o);

        }
    }

    public void update(Observable o, Object arg)
    {


        //JTable tabel = topicTableView1.getTable();
        //JTree tree = topicTreeView1.getJTree1();

        String key = ((OPSObject) arg).getKey();
        updateAvailableKeys(key);
        updateAvailablePublishers(subscriber.getMessage().getPublisherName());



//        String outString = "";
//
//        OPSObject oo = (OPSObject) arg;
//
//        outString += "publisherName = " + subscriber.getMessage().getPublisherName() + "\n";
//        outString += "publicationID = " + subscriber.getMessage().getPublicationID() + "\n";
//
//        //outString += "priority = " + oo.();
//
//
//        Field[] fields = arg.getClass().getFields();
//
//        for (int i = 0; i < fields.length; i++)
//        {
//            try
//            {
//                outString += fields[i].getName() + " = " + fields[i].get(arg) + "\n";
//            //tabel.getModel().setValueAt(fields[i].getName(), i + 2, 0);
//            //tabel.getModel().setValueAt(fields[i].get(arg), i + 2, 1);
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//                outString += "Error\n";
//            }
//
//        }


    //topicTableView1.updateUI();
    //topicTextArea1.setText("\"" + getName() + "\":\n" + outString);



    }

    public JTextField getKeyFilterField()
    {
        return keyFilterField;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyKeyFilterButton;
    private javax.swing.JButton applyPublisherFilterButton;
    private javax.swing.JComboBox availableKeysComboBox;
    private javax.swing.JComboBox availablePublishersComboBox;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField keyFilterField;
    private javax.swing.JTextField publisherFilterField;
    private javax.swing.JCheckBox suppressArraysCheckBox;
    private javax.swing.JTabbedPane tabbedPane1;
    private javax.swing.JButton timeBasedFilterSetButton;
    private javax.swing.JTextField timeBasedFilterTextField;
    private javax.swing.JLabel topicNameLabel;
    // End of variables declaration//GEN-END:variables
}
