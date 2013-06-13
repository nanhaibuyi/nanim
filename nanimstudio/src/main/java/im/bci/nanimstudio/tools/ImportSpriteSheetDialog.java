/*
 * Copyright (c) 2013 devnewton <devnewton@bci.im>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'devnewton <devnewton@bci.im>' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package im.bci.nanimstudio.tools;

import im.bci.nanimstudio.model.NanimStudioModel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bob
 */
public class ImportSpriteSheetDialog extends javax.swing.JDialog {
    
    private NanimStudioModel nanimStudio = NanimStudioModel.getInstance();

    /**
     * Creates new form OptimizeDialog
     */
    public ImportSpriteSheetDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton_import = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner_frame_width = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_frame_height = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_frame_duration = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton_import.setText("Import");
        jButton_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_importActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton_import, gridBagConstraints);

        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton_cancel, gridBagConstraints);

        jLabel1.setText("frame width:");
        getContentPane().add(jLabel1, new java.awt.GridBagConstraints());

        jSpinner_frame_width.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(32), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jSpinner_frame_width, gridBagConstraints);

        jLabel2.setText("frame height:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jLabel2, gridBagConstraints);

        jSpinner_frame_height.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(32), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jSpinner_frame_height, gridBagConstraints);

        jLabel3.setText("frame duration:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel3, gridBagConstraints);

        jSpinner_frame_duration.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jSpinner_frame_duration, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_importActionPerformed
        try {
            jSpinner_frame_width.commitEdit();
            jSpinner_frame_height.commitEdit();
            jSpinner_frame_duration.commitEdit();
            JFileChooser chooser = new JFileChooser(nanimStudio.getPreferences().get("lastSpriteSheetDirectory", null));
            chooser.setFileFilter(new FileNameExtensionFilter("png images", "png", "png"));
            if (JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(this)) {
                nanimStudio.getPreferences().put("lastSpriteSheetDirectory", chooser.getCurrentDirectory().getAbsolutePath());
                nanimStudio.getNanim().importSpriteSheet(chooser.getSelectedFile(), (Integer)jSpinner_frame_width.getValue(), (Integer)jSpinner_frame_height.getValue(), (Integer)jSpinner_frame_duration.getValue());
            }
            setVisible(false);
        } catch (ParseException ex) {
            Logger.getLogger(ImportSpriteSheetDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_importActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_import;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner_frame_duration;
    private javax.swing.JSpinner jSpinner_frame_height;
    private javax.swing.JSpinner jSpinner_frame_width;
    // End of variables declaration//GEN-END:variables


}