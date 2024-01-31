/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Classes;
import MainPackage.App;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author angel
 */
public class Home extends javax.swing.JFrame {
    
    private Point initialClick;
    private final App app = App.getInstance();
    private final CartoonNetwork cartoonNetwork = CartoonNetwork.getInstance();
    private final Nickelodeon nickelodeon = Nickelodeon.getInstance();

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btn_Inicio = new javax.swing.JPanel();
        icono1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_nuevo_pedido = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_nueva_ruta = new javax.swing.JPanel();
        icono3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_nuevo_almacen = new javax.swing.JPanel();
        icono4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_reporte = new javax.swing.JPanel();
        icono5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_cargar_guardar = new javax.swing.JPanel();
        icono7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(1130, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePanel.setBackground(new java.awt.Color(34, 46, 60));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Inicio.setBackground(new java.awt.Color(243, 168, 71));

        icono1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setText("Inicio");

        javax.swing.GroupLayout btn_InicioLayout = new javax.swing.GroupLayout(btn_Inicio);
        btn_Inicio.setLayout(btn_InicioLayout);
        btn_InicioLayout.setHorizontalGroup(
            btn_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_InicioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        btn_InicioLayout.setVerticalGroup(
            btn_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_InicioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        SidePanel.add(btn_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 330, 60));

        btn_nuevo_pedido.setBackground(new java.awt.Color(55, 71, 90));
        btn_nuevo_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_pedidoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_nuevo_pedidoLayout = new javax.swing.GroupLayout(btn_nuevo_pedido);
        btn_nuevo_pedido.setLayout(btn_nuevo_pedidoLayout);
        btn_nuevo_pedidoLayout.setHorizontalGroup(
            btn_nuevo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_pedidoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        btn_nuevo_pedidoLayout.setVerticalGroup(
            btn_nuevo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_pedidoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nuevo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        SidePanel.add(btn_nuevo_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 330, 60));

        btn_nueva_ruta.setBackground(new java.awt.Color(55, 71, 90));
        btn_nueva_ruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nueva_rutaMouseClicked(evt);
            }
        });

        icono3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono3MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cartoon Network");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_nueva_rutaLayout = new javax.swing.GroupLayout(btn_nueva_ruta);
        btn_nueva_ruta.setLayout(btn_nueva_rutaLayout);
        btn_nueva_rutaLayout.setHorizontalGroup(
            btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nueva_rutaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono3)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        btn_nueva_rutaLayout.setVerticalGroup(
            btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nueva_rutaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        SidePanel.add(btn_nueva_ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 330, 60));

        btn_nuevo_almacen.setBackground(new java.awt.Color(55, 71, 90));
        btn_nuevo_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_almacenMouseClicked(evt);
            }
        });

        icono4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Parámetros");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_nuevo_almacenLayout = new javax.swing.GroupLayout(btn_nuevo_almacen);
        btn_nuevo_almacen.setLayout(btn_nuevo_almacenLayout);
        btn_nuevo_almacenLayout.setHorizontalGroup(
            btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_almacenLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono4)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        btn_nuevo_almacenLayout.setVerticalGroup(
            btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_almacenLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(btn_nuevo_almacenLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        SidePanel.add(btn_nuevo_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 330, 60));

        btn_reporte.setBackground(new java.awt.Color(55, 71, 90));
        btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reporteMouseClicked(evt);
            }
        });

        icono5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono5MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Guardar");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_reporteLayout = new javax.swing.GroupLayout(btn_reporte);
        btn_reporte.setLayout(btn_reporteLayout);
        btn_reporteLayout.setHorizontalGroup(
            btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_reporteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono5)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        btn_reporteLayout.setVerticalGroup(
            btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_reporteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        SidePanel.add(btn_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 60));

        btn_cargar_guardar.setBackground(new java.awt.Color(55, 71, 90));
        btn_cargar_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cargar_guardarMouseClicked(evt);
            }
        });

        icono7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono7MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nickelodeon");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_cargar_guardarLayout = new javax.swing.GroupLayout(btn_cargar_guardar);
        btn_cargar_guardar.setLayout(btn_cargar_guardarLayout);
        btn_cargar_guardarLayout.setHorizontalGroup(
            btn_cargar_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cargar_guardarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icono7)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        btn_cargar_guardarLayout.setVerticalGroup(
            btn_cargar_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cargar_guardarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_cargar_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        SidePanel.add(btn_cargar_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unimet 2024 ®");
        SidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, -1, -1));

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SidePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 26));
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 80));

        jPanel1.add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 720));

        jPanel2.setBackground(new java.awt.Color(34, 46, 60));

        jPanel4.setBackground(new java.awt.Color(246, 183, 102));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Assets/exit.png"))); // NOI18N
        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 1059, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 190));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_nuevo_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_pedidoMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btn_nuevo_pedidoMouseClicked

    private void icono3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono3MouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_icono3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        cartoonNetwork.setVisible(true);
        cartoonNetwork.setLocationRelativeTo(null);
        cartoonNetwork.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/cartoonNetworkTheme.wav"); 
        this.setVisible(false);
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void cartoonPlayMusic(String path) {
        try {
            URL url = this.getClass().getResource(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    private void btn_nueva_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nueva_rutaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_nueva_rutaMouseClicked

    private void icono4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono4MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_icono4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btn_nuevo_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_almacenMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btn_nuevo_almacenMouseClicked

    private void icono7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono7MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_icono7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        nickelodeon.setVisible(true);
        nickelodeon.setLocationRelativeTo(null);
        nickelodeon.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/nickelodeonTheme.wav"); 
        this.setVisible(false);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btn_cargar_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargar_guardarMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btn_cargar_guardarMouseClicked

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
        int x = getLocation().x - initialClick.x + evt.getX();
        int y = getLocation().y - initialClick.y + evt.getY();
        setLocation(x, y);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reporteMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_reporteMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel8MouseClicked

    private void icono5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_icono5MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel btn_Inicio;
    private javax.swing.JPanel btn_cargar_guardar;
    private javax.swing.JPanel btn_nueva_ruta;
    private javax.swing.JPanel btn_nuevo_almacen;
    private javax.swing.JPanel btn_nuevo_pedido;
    private javax.swing.JPanel btn_reporte;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel icono3;
    private javax.swing.JLabel icono4;
    private javax.swing.JLabel icono5;
    private javax.swing.JLabel icono7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
