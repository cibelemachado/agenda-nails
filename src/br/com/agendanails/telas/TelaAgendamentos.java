package br.com.agendanails.telas;
        
import br.com.agendanails.*;     
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.agendanails.dao.AgendamentoDAO;
import br.com.agendanails.dao.ClienteDAO;
import br.com.agendanails.dao.ServicoDAO;
import br.com.agendanails.dao.ProfissionalDAO;

public class TelaAgendamentos extends javax.swing.JFrame {

   private ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();
   private ArrayList<Cliente> listaClientes;
   private ArrayList<Profissional> listaProfissionais;
   private ArrayList<Servico> listaServicos;
    
    public TelaAgendamentos() {
        initComponents();
        this.listaClientes = new ArrayList<>();
        this.listaProfissionais = new ArrayList<>();
        this.listaServicos = new ArrayList<>();
        this.listaAgendamentos = new ArrayList<>();        
        
        carregarClientesProfissionaisServicos();
        carregarDoBanco();
        preencherCombos();
    }
    
    private void preencherCombos() {
        cmbCliente.removeAllItems();
        cmbProfissional.removeAllItems();
        cmbServico.removeAllItems();
        
        for (Cliente c : listaClientes) {
            cmbCliente.addItem(c.getNome());
        }
        for (Profissional p : listaProfissionais){
            cmbProfissional.addItem(p.getNome());
        }
        for (Servico s : listaServicos) {
            cmbServico.addItem(s.getNome());
        }
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        cmbServico = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbProfissional = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("AGENDAMENTO DE SERVIÇOS");

        tblAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Profissional", "Serviço", "Data/ Hora"
            }
        ));
        jScrollPane1.setViewportView(tblAgendamentos);

        cmbServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicoActionPerformed(evt);
            }
        });

        lblData.setText("Data:");

        lblHora.setText("Hora:");

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Cliente:");

        jLabel2.setText("Nome do Profissional:");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        cmbProfissional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProfissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProfissionalActionPerformed(evt);
            }
        });

        jLabel3.setText("Serviços:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbServico, 0, 192, Short.MAX_VALUE)
                            .addComponent(txtData)
                            .addComponent(txtHora)
                            .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProfissional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnVoltar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        String nomeCliente = cmbCliente.getSelectedItem()!= null ? cmbCliente.getSelectedItem().toString().trim() : "";
        String nomeProfissional = cmbProfissional.getSelectedItem()!= null ? cmbProfissional.getSelectedItem().toString().trim() : "";   
        String nomeServico = cmbServico.getSelectedItem() != null ? cmbServico.getSelectedItem().toString().trim() : "";
        String data = txtData.getText().trim();
        String hora = txtHora.getText().trim();

        if (nomeCliente.isEmpty() || nomeProfissional.isEmpty() || nomeServico.isEmpty()
            || data.isEmpty() || hora.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
        }
     
        Cliente cliente = null;
        Profissional profissional = null;
        Servico servico = null;

    try {
        // Tentar construtores comuns: Cliente(String nome, String telefone)
        cliente = new Cliente(nomeCliente, "(00)0000-0000");
    } catch (Throwable t) {
        // Se o seu Cliente exige id, tente com id 0
        try {
            cliente = new Cliente(0, nomeCliente, "(00)0000-0000");
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(this, "Construtor de Cliente incompatível. Verifique a classe Cliente.");
            return;
        }
    }

    try {
        // Profissional(String nome, String especialidade, String horario)
        profissional = new Profissional(nomeProfissional, "Especialidade", "09:00-18:00");
    } catch (Throwable t) {
        try {
            profissional = new Profissional(0, nomeProfissional, "Especialidade", "09:00-18:00");
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(this, "Construtor de Profissional incompatível. Verifique a classe Profissional.");
            return;
        }
    }

    try {
        // Se Servico tem (String nome, String descricao, double preco, int duracao)
        servico = new Servico(nomeServico, "Serviço padrão", 50.0, 60);
    } catch (Throwable t) {
        try {
            servico = new Servico(0, nomeServico, "Serviço padrão", 50.0, 60);
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(this, "Construtor de Servico incompatível. Verifique a classe Servico.");
            return;
        }
    }

    // Cria o agendamento (ajuste se Agendamento tiver outro construtor)
    Agendamento ag = null;
    
    try {
        ag = new Agendamento(cliente, profissional, servico, data + " " + hora);
    } catch (Throwable t) {
        try {
           java.time.LocalDateTime dataHora = java.time.LocalDateTime.parse(data + "T" + hora);
           ag = new Agendamento(0, cliente, profissional, servico, dataHora);
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(this, "Construtor de Agendamento incompatível. Verifique a classe Agendamento.");
            return;
        }      
    }
    
    if (ag != null) {
        listaAgendamentos.add(ag);
        atualizarTabela();
        limparCampos();
        JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
    }           
    }//GEN-LAST:event_btnAgendarActionPerformed
    
    private void carregarClientesProfissionaisServicos() {
        
        ClienteDAO clienteDAO = new ClienteDAO();
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        
        this.listaClientes = new ArrayList<>(clienteDAO.listarClientes());
        this.listaProfissionais = new ArrayList<>(profissionalDAO.listarTodos());
        this.listaServicos = new ArrayList<>(servicoDAO.listarServicos());
    }
  
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void cmbServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbServicoActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProfissionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProfissionalActionPerformed

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblAgendamentos.getModel();
        modelo.setRowCount(0);
        
        for (Agendamento a : listaAgendamentos) {
            modelo.addRow(new Object[]{
                a.getCliente().getNome(),
                a.getProfissional().getNome(),
                a.getServico().getNome(),
                a.getDataHora()
        });
        }
    }
    
    private void carregarDoBanco() {
        AgendamentoDAO dao = new AgendamentoDAO();
        ArrayList<Agendamento> lista = new ArrayList<>(dao.listarAgendamentos());

        this.listaAgendamentos = lista;
        atualizarTabela();
    }
    
    private void limparCampos(){    
        txtData.setText("");
        txtHora.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProfissional;
    private javax.swing.JComboBox<String> cmbServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAgendamentos;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
