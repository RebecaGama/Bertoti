package gui;

import gui.Fornecedor;
import gui.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rebeca
 */
public class FloriculturaPrincipal extends javax.swing.JFrame {
    ArrayList<Fornecedor> ListaForn;
    ArrayList<Produto> ListaProd;
    String modoForn;
    String modoProd;
    
    public void LoadTableForn(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CNPJ","Nome"},0);
            
        for(int i=0;i<ListaForn.size();i++){
            Object linha[] = new Object[]{ListaForn.get(i).getCnpj(),
                                          ListaForn.get(i).getNome()};
            modelo.addRow(linha);
        }
        
        tbl_forn_dpts.setModel(modelo);
        tbl_forn_dpts.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_forn_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        LoadCBforn();
    }
    
    public void LoadTableProd(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código","Nome","Preço","Quantidade", "Fornecedor"},0);
            
        for(int i=0;i<ListaProd.size();i++){
            Object linha[] = new Object[]{ListaProd.get(i).getCodigo(),
                                          ListaProd.get(i).getNome(),
                                          ListaProd.get(i).getPreco(),
                                          ListaProd.get(i).getQuantidade(),
                                          ListaProd.get(i).getForn().getNome(),};
            modelo.addRow(linha);
        }
        
        tbl_prod_funcs.setModel(modelo);
        tbl_prod_funcs.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_prod_funcs.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_prod_funcs.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_prod_funcs.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    
    public void LoadCBforn(){
        cb_prod_forn.removeAllItems();
        cb_prod_forn.addItem("Selecione");
        for(int i=0;i<ListaForn.size();i++){
            cb_prod_forn.addItem(ListaForn.get(i).getNome());
        }
    }
    
    /**
     * Creates new form Principal
     */
    public FloriculturaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaForn = new ArrayList();
        ListaProd = new ArrayList();
        modoForn = "Navegar";
        modoProd = "Navegar";
        ManipulaInterfaceForn();
        ManipulaInterfaceProd();
    }
    
    public void ManipulaInterfaceForn(){
        switch(modoForn){
            case "Navegar":
                lb_forn_salvar.setEnabled(false);
                lb_forn_cancelar.setEnabled(false);
                c_forn_cnpj.setEnabled(false);
                c_forn_nome.setEnabled(false);
                lb_forn_novo.setEnabled(true);
                lb_forn_editar.setEnabled(false);
                lb_forn_excluir.setEnabled(false);
                break;
            
            case "Novo":
                lb_forn_salvar.setEnabled(true);
                lb_forn_cancelar.setEnabled(true);
                c_forn_cnpj.setEnabled(true);
                c_forn_nome.setEnabled(true);
                lb_forn_novo.setEnabled(false);
                lb_forn_editar.setEnabled(false);
                lb_forn_excluir.setEnabled(false);
                break;
                
            case "Editar":
                lb_forn_salvar.setEnabled(true);
                lb_forn_cancelar.setEnabled(true);
                c_forn_cnpj.setEnabled(true);
                c_forn_nome.setEnabled(true);
                lb_forn_novo.setEnabled(true);
                lb_forn_editar.setEnabled(false);
                lb_forn_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                lb_forn_salvar.setEnabled(false);
                lb_forn_cancelar.setEnabled(false);
                c_forn_cnpj.setEnabled(false);
                c_forn_nome.setEnabled(false);
                lb_forn_novo.setEnabled(true);
                lb_forn_editar.setEnabled(false);
                lb_forn_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                lb_forn_salvar.setEnabled(false);
                lb_forn_cancelar.setEnabled(false);
                c_forn_cnpj.setEnabled(false);
                c_forn_nome.setEnabled(false);
                lb_forn_novo.setEnabled(true);
                lb_forn_editar.setEnabled(true);
                lb_forn_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    
    public void ManipulaInterfaceProd(){
        switch(modoProd){
            case "Navegar":
                lb_prod_salvar.setEnabled(false);
                lb_prod_cancelar.setEnabled(false);
                c_prod_cod.setEnabled(false);
                c_prod_nome.setEnabled(false);
                c_prod_preco.setEnabled(false);
                c_prod_quantidade.setEnabled(false);
                lb_prod_novo.setEnabled(true);
                lb_prod_editar.setEnabled(false);
                lb_prod_excluir.setEnabled(false);
                cb_prod_forn.setEnabled(false);
                break;
            
            case "Novo":
                lb_prod_salvar.setEnabled(true);
                lb_prod_cancelar.setEnabled(true);
                c_prod_cod.setEnabled(true);
                c_prod_nome.setEnabled(true);
                c_prod_preco.setEnabled(true);
                c_prod_quantidade.setEnabled(true);
                cb_prod_forn.setEnabled(true);
                lb_prod_novo.setEnabled(false);
                lb_prod_editar.setEnabled(false);
                lb_prod_excluir.setEnabled(false);
                break;
                
            case "Editar":
                lb_prod_salvar.setEnabled(true);
                lb_prod_cancelar.setEnabled(true);
                c_prod_cod.setEnabled(true);
                c_prod_nome.setEnabled(true);
                c_prod_preco.setEnabled(true);
                c_prod_quantidade.setEnabled(true);
                cb_prod_forn.setEnabled(true);
                lb_prod_novo.setEnabled(true);
                lb_prod_editar.setEnabled(false);
                lb_prod_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                lb_prod_salvar.setEnabled(false);
                lb_prod_cancelar.setEnabled(false);
                c_prod_cod.setEnabled(false);
                c_prod_nome.setEnabled(false);
                c_prod_preco.setEnabled(false);
                c_prod_quantidade.setEnabled(false);
                cb_prod_forn.setEnabled(false);
                lb_prod_novo.setEnabled(true);
                lb_prod_editar.setEnabled(false);
                lb_prod_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                lb_prod_salvar.setEnabled(false);
                lb_prod_cancelar.setEnabled(false);
                c_prod_cod.setEnabled(false);
                c_prod_nome.setEnabled(false);
                c_prod_preco.setEnabled(false);
                c_prod_quantidade.setEnabled(false);
                cb_prod_forn.setEnabled(false);
                lb_prod_novo.setEnabled(true);
                lb_prod_editar.setEnabled(true);
                lb_prod_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFloricultura = new javax.swing.JPanel();
        lbFloricultura = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_forn_dpts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbCNPJ = new javax.swing.JLabel();
        c_forn_cnpj = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        c_forn_nome = new javax.swing.JTextField();
        jPanelSalvar = new javax.swing.JPanel();
        lb_forn_salvar = new javax.swing.JLabel();
        jPanelCancelar = new javax.swing.JPanel();
        lb_forn_cancelar = new javax.swing.JLabel();
        jPanelNovoF = new javax.swing.JPanel();
        lb_forn_novo = new javax.swing.JLabel();
        jPanelEditarF = new javax.swing.JPanel();
        lb_forn_editar = new javax.swing.JLabel();
        jPanelExcluirF = new javax.swing.JPanel();
        lb_forn_excluir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prod_funcs = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        c_prod_cod = new javax.swing.JTextField();
        lbNomeP = new javax.swing.JLabel();
        c_prod_nome = new javax.swing.JTextField();
        lbFornecedorP = new javax.swing.JLabel();
        cb_prod_forn = new javax.swing.JComboBox();
        c_prod_preco = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        c_prod_quantidade = new javax.swing.JTextField();
        jPanelCancelarP = new javax.swing.JPanel();
        lb_prod_cancelar = new javax.swing.JLabel();
        jPanelSalvarP = new javax.swing.JPanel();
        lb_prod_salvar = new javax.swing.JLabel();
        jPanelExcluirP = new javax.swing.JPanel();
        lb_prod_excluir = new javax.swing.JLabel();
        jPanelEditarP = new javax.swing.JPanel();
        lb_prod_editar = new javax.swing.JLabel();
        jPanelNovoP = new javax.swing.JPanel();
        lb_prod_novo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFloricultura.setBackground(new java.awt.Color(244, 221, 218));

        lbFloricultura.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbFloricultura.setForeground(new java.awt.Color(112, 67, 67));
        lbFloricultura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFloricultura.setText("SISTEMA FLORICULTURA");

        javax.swing.GroupLayout jPanelFloriculturaLayout = new javax.swing.GroupLayout(jPanelFloricultura);
        jPanelFloricultura.setLayout(jPanelFloriculturaLayout);
        jPanelFloriculturaLayout.setHorizontalGroup(
            jPanelFloriculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFloricultura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFloriculturaLayout.setVerticalGroup(
            jPanelFloriculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFloricultura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jTabbedPane1.setBackground(new java.awt.Color(217, 217, 217));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));

        tbl_forn_dpts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_forn_dpts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_forn_dptsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_forn_dpts);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Fornecedor"));

        lbCNPJ.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCNPJ.setText("CNPJ:");

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNome.setText("Nome:");

        jPanelSalvar.setBackground(new java.awt.Color(217, 217, 217));

        lb_forn_salvar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_forn_salvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_forn_salvar.setText("Salvar");
        lb_forn_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forn_salvarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvarLayout = new javax.swing.GroupLayout(jPanelSalvar);
        jPanelSalvar.setLayout(jPanelSalvarLayout);
        jPanelSalvarLayout.setHorizontalGroup(
            jPanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelSalvarLayout.setVerticalGroup(
            jPanelSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanelCancelar.setBackground(new java.awt.Color(217, 217, 217));

        lb_forn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_forn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_forn_cancelar.setText("Cancelar");
        lb_forn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forn_cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCancelarLayout = new javax.swing.GroupLayout(jPanelCancelar);
        jPanelCancelar.setLayout(jPanelCancelarLayout);
        jPanelCancelarLayout.setHorizontalGroup(
            jPanelCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelCancelarLayout.setVerticalGroup(
            jPanelCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanelSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCNPJ)
                            .addComponent(lbNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_forn_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(c_forn_cnpj))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCNPJ)
                            .addComponent(c_forn_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(c_forn_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jPanelSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelNovoF.setBackground(new java.awt.Color(255, 255, 255));

        lb_forn_novo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_forn_novo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_forn_novo.setText("Novo");
        lb_forn_novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forn_novoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNovoFLayout = new javax.swing.GroupLayout(jPanelNovoF);
        jPanelNovoF.setLayout(jPanelNovoFLayout);
        jPanelNovoFLayout.setHorizontalGroup(
            jPanelNovoFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_novo, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelNovoFLayout.setVerticalGroup(
            jPanelNovoFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelEditarF.setBackground(new java.awt.Color(255, 255, 255));

        lb_forn_editar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_forn_editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_forn_editar.setText("Editar");
        lb_forn_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forn_editarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelEditarFLayout = new javax.swing.GroupLayout(jPanelEditarF);
        jPanelEditarF.setLayout(jPanelEditarFLayout);
        jPanelEditarFLayout.setHorizontalGroup(
            jPanelEditarFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanelEditarFLayout.setVerticalGroup(
            jPanelEditarFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelExcluirF.setBackground(new java.awt.Color(255, 255, 255));

        lb_forn_excluir.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_forn_excluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_forn_excluir.setText("Excluir");
        lb_forn_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forn_excluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelExcluirFLayout = new javax.swing.GroupLayout(jPanelExcluirF);
        jPanelExcluirF.setLayout(jPanelExcluirFLayout);
        jPanelExcluirFLayout.setHorizontalGroup(
            jPanelExcluirFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelExcluirFLayout.setVerticalGroup(
            jPanelExcluirFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_forn_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelNovoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelEditarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jPanelExcluirF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelEditarF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNovoF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelExcluirF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fornecedores", jPanel1);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        tbl_prod_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Quantidade", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_prod_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prod_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prod_funcs);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Produto"));

        lbCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCodigo.setText("Código:");

        lbNomeP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNomeP.setText("Nome:");

        c_prod_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_prod_nomeActionPerformed(evt);
            }
        });

        lbFornecedorP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbFornecedorP.setText("Fornecedor:");

        cb_prod_forn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_prod_fornActionPerformed(evt);
            }
        });

        c_prod_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_prod_precoActionPerformed(evt);
            }
        });

        lbPreco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPreco.setText("Preço:");

        lbQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQuantidade.setText("Quantidade:");

        jPanelCancelarP.setBackground(new java.awt.Color(217, 217, 217));

        lb_prod_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_prod_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prod_cancelar.setText("Cancelar");
        lb_prod_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_prod_cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCancelarPLayout = new javax.swing.GroupLayout(jPanelCancelarP);
        jPanelCancelarP.setLayout(jPanelCancelarPLayout);
        jPanelCancelarPLayout.setHorizontalGroup(
            jPanelCancelarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelCancelarPLayout.setVerticalGroup(
            jPanelCancelarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanelSalvarP.setBackground(new java.awt.Color(217, 217, 217));

        lb_prod_salvar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_prod_salvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prod_salvar.setText("Salvar");
        lb_prod_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_prod_salvarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalvarPLayout = new javax.swing.GroupLayout(jPanelSalvarP);
        jPanelSalvarP.setLayout(jPanelSalvarPLayout);
        jPanelSalvarPLayout.setHorizontalGroup(
            jPanelSalvarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelSalvarPLayout.setVerticalGroup(
            jPanelSalvarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jPanelSalvarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jPanelCancelarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(lbNomeP)
                    .addComponent(lbPreco))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(c_prod_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(c_prod_preco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_prod_cod, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuantidade)
                    .addComponent(lbFornecedorP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c_prod_quantidade)
                    .addComponent(cb_prod_forn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(c_prod_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuantidade)
                    .addComponent(c_prod_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeP)
                    .addComponent(c_prod_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_prod_forn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFornecedorP))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_prod_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelCancelarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSalvarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelExcluirP.setBackground(new java.awt.Color(255, 255, 255));

        lb_prod_excluir.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_prod_excluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prod_excluir.setText("Excluir");
        lb_prod_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_prod_excluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelExcluirPLayout = new javax.swing.GroupLayout(jPanelExcluirP);
        jPanelExcluirP.setLayout(jPanelExcluirPLayout);
        jPanelExcluirPLayout.setHorizontalGroup(
            jPanelExcluirPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelExcluirPLayout.setVerticalGroup(
            jPanelExcluirPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanelEditarP.setBackground(new java.awt.Color(255, 255, 255));

        lb_prod_editar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_prod_editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prod_editar.setText("Editar");
        lb_prod_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_prod_editarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelEditarPLayout = new javax.swing.GroupLayout(jPanelEditarP);
        jPanelEditarP.setLayout(jPanelEditarPLayout);
        jPanelEditarPLayout.setHorizontalGroup(
            jPanelEditarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_editar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanelEditarPLayout.setVerticalGroup(
            jPanelEditarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelNovoP.setBackground(new java.awt.Color(255, 255, 255));

        lb_prod_novo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lb_prod_novo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_prod_novo.setText("Novo");
        lb_prod_novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_prod_novoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNovoPLayout = new javax.swing.GroupLayout(jPanelNovoP);
        jPanelNovoP.setLayout(jPanelNovoPLayout);
        jPanelNovoPLayout.setHorizontalGroup(
            jPanelNovoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_novo, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        jPanelNovoPLayout.setVerticalGroup(
            jPanelNovoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_prod_novo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelNovoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jPanelExcluirP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelNovoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEditarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelExcluirP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produtos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFloricultura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFloricultura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_forn_dptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_forn_dptsMouseClicked
        int index = tbl_forn_dpts.getSelectedRow();
        if(index>=0 && index<ListaForn.size()){
            Fornecedor F = ListaForn.get(index);
            c_forn_cnpj.setText(String.valueOf(F.getCnpj()));
            c_forn_nome.setText(F.getNome());
            modoForn = "Selecao";
            ManipulaInterfaceForn();
        }
    }//GEN-LAST:event_tbl_forn_dptsMouseClicked

    private void lb_forn_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forn_salvarMouseClicked
        int cnpj = Integer.parseInt(c_forn_cnpj.getText());
        if(modoForn.equals("Novo")){
            Fornecedor F = new Fornecedor(cnpj, c_forn_nome.getText());
            ListaForn.add(F);
        }else if(modoForn.equals("Editar")){
            int index = tbl_forn_dpts.getSelectedRow();
            ListaForn.get(index).setCnpj(cnpj);
            ListaForn.get(index).setNome(c_forn_nome.getText());
        }

        LoadTableForn();
        modoForn = "Navegar";
        ManipulaInterfaceForn();
        c_forn_cnpj.setText("");
        c_forn_nome.setText("");
    }//GEN-LAST:event_lb_forn_salvarMouseClicked

    private void lb_forn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forn_cancelarMouseClicked
        c_forn_cnpj.setText("");
        c_forn_nome.setText("");
        modoForn = "Navegar";
        ManipulaInterfaceForn();
    }//GEN-LAST:event_lb_forn_cancelarMouseClicked

    private void lb_forn_novoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forn_novoMouseClicked
        c_forn_cnpj.setText("");
        c_forn_nome.setText("");

        modoForn = "Novo";
        ManipulaInterfaceForn();
    }//GEN-LAST:event_lb_forn_novoMouseClicked

    private void lb_forn_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forn_editarMouseClicked
        modoForn = "Editar";
        ManipulaInterfaceForn();
    }//GEN-LAST:event_lb_forn_editarMouseClicked

    private void lb_forn_excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forn_excluirMouseClicked
        int index = tbl_forn_dpts.getSelectedRow();
        if(index>=0 && index<ListaForn.size()){
            ListaForn.remove(index);
        }
        LoadTableForn();
        modoForn = "Navegar";
        ManipulaInterfaceForn();
    }//GEN-LAST:event_lb_forn_excluirMouseClicked

    private void tbl_prod_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prod_funcsMouseClicked
        int index = tbl_prod_funcs.getSelectedRow();
        if(index>=0 && index<ListaProd.size()){
            Produto P = ListaProd.get(index);
            c_prod_cod.setText(String.valueOf(P.getCodigo()));
            c_prod_nome.setText(P.getNome());
            c_prod_preco.setText(String.valueOf(P.getPreco()));
            c_prod_quantidade.setText(String.valueOf(P.getQuantidade()));
            modoForn = "Selecao";
            ManipulaInterfaceForn();
        }
    }//GEN-LAST:event_tbl_prod_funcsMouseClicked

    private void c_prod_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_prod_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_prod_nomeActionPerformed

    private void cb_prod_fornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_prod_fornActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_prod_fornActionPerformed

    private void c_prod_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_prod_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_prod_precoActionPerformed

    private void lb_prod_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_prod_cancelarMouseClicked
        c_prod_cod.setText("");
        c_prod_nome.setText("");
        c_prod_preco.setText("");
        c_prod_quantidade.setText("");
        modoProd = "Navegar";
        ManipulaInterfaceProd();
    }//GEN-LAST:event_lb_prod_cancelarMouseClicked

    private void lb_prod_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_prod_salvarMouseClicked
        int index = cb_prod_forn.getSelectedIndex();
        if(index==0){
            JOptionPane.showMessageDialog(this,"Você deve selecionar um fornecedor");
        }else{
            Produto P = new Produto();
            P.setCodigo(Integer.parseInt(c_prod_cod.getText()));
            P.setNome(c_prod_nome.getText());
            P.setPreco(Float.parseFloat(c_prod_preco.getText()));
            P.setQuantidade(Integer.parseInt(c_prod_quantidade.getText()));
            P.setForn(ListaForn.get(index-1));

            ListaProd.add(P);
            ListaForn.get(index-1).addProd(P);
        }
        LoadTableProd();
        modoProd = "Navegar";
        ManipulaInterfaceProd();
    }//GEN-LAST:event_lb_prod_salvarMouseClicked

    private void lb_prod_excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_prod_excluirMouseClicked
        int index = tbl_prod_funcs.getSelectedRow();
        if(index>=0 && index<ListaProd.size()){
            ListaProd.remove(index);
        }
        LoadTableProd();
        modoProd = "Navegar";
        ManipulaInterfaceProd();
    }//GEN-LAST:event_lb_prod_excluirMouseClicked

    private void lb_prod_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_prod_editarMouseClicked
        modoProd = "Editar";
        ManipulaInterfaceProd();
    }//GEN-LAST:event_lb_prod_editarMouseClicked

    private void lb_prod_novoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_prod_novoMouseClicked
        c_prod_cod.setText("");
        c_prod_nome.setText("");
        c_prod_preco.setText("");
        c_prod_quantidade.setText("");

        modoProd = "Novo";
        ManipulaInterfaceProd();
    }//GEN-LAST:event_lb_prod_novoMouseClicked

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
            java.util.logging.Logger.getLogger(FloriculturaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FloriculturaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FloriculturaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FloriculturaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FloriculturaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c_forn_cnpj;
    private javax.swing.JTextField c_forn_nome;
    private javax.swing.JTextField c_prod_cod;
    private javax.swing.JTextField c_prod_nome;
    private javax.swing.JTextField c_prod_preco;
    private javax.swing.JTextField c_prod_quantidade;
    private javax.swing.JComboBox cb_prod_forn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCancelar;
    private javax.swing.JPanel jPanelCancelarP;
    private javax.swing.JPanel jPanelEditarF;
    private javax.swing.JPanel jPanelEditarP;
    private javax.swing.JPanel jPanelExcluirF;
    private javax.swing.JPanel jPanelExcluirP;
    private javax.swing.JPanel jPanelFloricultura;
    private javax.swing.JPanel jPanelNovoF;
    private javax.swing.JPanel jPanelNovoP;
    private javax.swing.JPanel jPanelSalvar;
    private javax.swing.JPanel jPanelSalvarP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbCNPJ;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFloricultura;
    private javax.swing.JLabel lbFornecedorP;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeP;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lb_forn_cancelar;
    private javax.swing.JLabel lb_forn_editar;
    private javax.swing.JLabel lb_forn_excluir;
    private javax.swing.JLabel lb_forn_novo;
    private javax.swing.JLabel lb_forn_salvar;
    private javax.swing.JLabel lb_prod_cancelar;
    private javax.swing.JLabel lb_prod_editar;
    private javax.swing.JLabel lb_prod_excluir;
    private javax.swing.JLabel lb_prod_novo;
    private javax.swing.JLabel lb_prod_salvar;
    private javax.swing.JTable tbl_forn_dpts;
    private javax.swing.JTable tbl_prod_funcs;
    // End of variables declaration//GEN-END:variables

    private void LoadCBForn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}