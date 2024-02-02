/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Classes;

import FileFunctions.FileFunctions;
import Helpers.HelpersFunctions;
import MainClasses.Employee;
import MainPackage.App;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Erika A. Hernández Z.
 */
public class ConfigParams extends javax.swing.JFrame {

    private Point initialClick;
    private final App app = App.getInstance();
    private int maxEmployees0;
    private int maxEmployees1;
    private int actualEmployees0;
    private int actualEmployees1;
    private static ConfigParams config;
    private static CartoonNetwork cartoonNetwork;
    private static Nickelodeon nickelodeon;
    private HelpersFunctions helper = new HelpersFunctions();
    private FileFunctions filefunctions = new FileFunctions();
    private File selectedFile = app.getSelectedFile();

    public ConfigParams() {
        try {
            // Código para el Look and Feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initializeValues();
    }

    private void initializeValues() {
        if (this.app.getCartoonNetwork() != null && this.app.getNickelodeon() != null) {
            this.maxEmployees0 = this.app.getNickelodeon().getMaxEmployeesQuantity();
            this.maxEmployees1 = this.app.getCartoonNetwork().getMaxEmployeesQuantity();
            this.actualEmployees1 = this.app.getCartoonNetwork().getActualEmployeesQuantity();
            this.actualEmployees0 = this.app.getNickelodeon().getActualEmployeesQuantity();

            this.dayDuration.setText(String.valueOf(app.getDayDuration()/1000));
            this.deadlineValue.setText(String.valueOf(app.getDeadline()));

            this.scriptsValues0.setText(String.valueOf(countNonNullEmployees(this.app.getNickelodeon().getScreenwriters())));
            this.scenaryValue0
                    .setText(String.valueOf(countNonNullEmployees(this.app.getNickelodeon().getSetDesigners())));
            this.animationValues0.setText(
                    String.valueOf(countNonNullEmployees(this.app.getNickelodeon().getCharacterAnimators())));
            this.dubbingValues0
                    .setText(String.valueOf(countNonNullEmployees(this.app.getNickelodeon().getVoiceActors())));
            this.plotTwistValues0.setText(
                    String.valueOf(countNonNullEmployees(this.app.getNickelodeon().getPlotTwistScreenwriters())));

            this.scriptsValues1.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getScreenwriters())));
            this.scenaryValue1
                    .setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getSetDesigners())));
            this.animationValues1.setText(
                    String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getCharacterAnimators())));
            this.dubbingValues1
                    .setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getVoiceActors())));
            this.plotTwistValues1.setText(
                    String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getPlotTwistScreenwriters())));

        }
    }

    private int countNonNullEmployees(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static synchronized ConfigParams getInstance() {
        if (config == null) {
            config = new ConfigParams();
        }
        return config;
    }

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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btn_cargar_guardar = new javax.swing.JPanel();
        icono7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        driveTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        scripts1 = new javax.swing.JPanel();
        scriptsTitle1 = new javax.swing.JLabel();
        increaseScripts1 = new javax.swing.JButton();
        dayDuration = new javax.swing.JTextField();
        decreaseScripts1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        scripts3 = new javax.swing.JPanel();
        scriptsTitle3 = new javax.swing.JLabel();
        increaseScripts3 = new javax.swing.JButton();
        deadlineValue = new javax.swing.JTextField();
        decreaseScripts3 = new javax.swing.JButton();
        workersConfigurations5 = new javax.swing.JPanel();
        driveTitle11 = new javax.swing.JLabel();
        scripts6 = new javax.swing.JPanel();
        scriptsTitle6 = new javax.swing.JLabel();
        increaseScripts6 = new javax.swing.JButton();
        scriptsValues1 = new javax.swing.JTextField();
        decreaseScripts6 = new javax.swing.JButton();
        scenary5 = new javax.swing.JPanel();
        scenaryTitle5 = new javax.swing.JLabel();
        scenaryValue1 = new javax.swing.JTextField();
        increaseScenary5 = new javax.swing.JButton();
        decreaseScenary5 = new javax.swing.JButton();
        animations5 = new javax.swing.JPanel();
        animationsTitle5 = new javax.swing.JLabel();
        animationValues1 = new javax.swing.JTextField();
        decreaseAnimation5 = new javax.swing.JButton();
        increaseAnimation5 = new javax.swing.JButton();
        dubbing5 = new javax.swing.JPanel();
        dubbingTitle5 = new javax.swing.JLabel();
        decreaseDubbing5 = new javax.swing.JButton();
        dubbingValues1 = new javax.swing.JTextField();
        increaseDubbing5 = new javax.swing.JButton();
        plotTwist5 = new javax.swing.JPanel();
        plotTwistTitle5 = new javax.swing.JLabel();
        increasePlotTwist5 = new javax.swing.JButton();
        plotTwistValues1 = new javax.swing.JTextField();
        decreacePlotTwist5 = new javax.swing.JButton();
        driveTitle12 = new javax.swing.JLabel();
        workersConfigurations6 = new javax.swing.JPanel();
        driveTitle13 = new javax.swing.JLabel();
        scripts7 = new javax.swing.JPanel();
        scriptsTitle7 = new javax.swing.JLabel();
        increaseScripts7 = new javax.swing.JButton();
        scriptsValues0 = new javax.swing.JTextField();
        decreaseScripts = new javax.swing.JButton();
        scenary6 = new javax.swing.JPanel();
        scenaryTitle6 = new javax.swing.JLabel();
        scenaryValue0 = new javax.swing.JTextField();
        increaseScenary6 = new javax.swing.JButton();
        decreaseScenary6 = new javax.swing.JButton();
        animations6 = new javax.swing.JPanel();
        animationsTitle6 = new javax.swing.JLabel();
        animationValues0 = new javax.swing.JTextField();
        decreaseAnimation6 = new javax.swing.JButton();
        increaseAnimation6 = new javax.swing.JButton();
        dubbing6 = new javax.swing.JPanel();
        dubbingTitle6 = new javax.swing.JLabel();
        decreaseDubbing6 = new javax.swing.JButton();
        dubbingValues0 = new javax.swing.JTextField();
        increaseDubbing6 = new javax.swing.JButton();
        plotTwist6 = new javax.swing.JPanel();
        plotTwistTitle6 = new javax.swing.JLabel();
        increasePlotTwist6 = new javax.swing.JButton();
        plotTwistValues0 = new javax.swing.JTextField();
        decreacePlotTwist6 = new javax.swing.JButton();
        driveTitle14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePanel.setBackground(new java.awt.Color(34, 46, 60));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Inicio.setBackground(new java.awt.Color(55, 71, 90));
        btn_Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_InicioMouseClicked(evt);
            }
        });

        icono1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

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
                .addContainerGap(183, Short.MAX_VALUE))
        );
        btn_nuevo_pedidoLayout.setVerticalGroup(
            btn_nuevo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_pedidoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nuevo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
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
                .addContainerGap(123, Short.MAX_VALUE))
        );
        btn_nueva_rutaLayout.setVerticalGroup(
            btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nueva_rutaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icono3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
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
        jLabel7.setText("Nickelodeon");
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
                .addContainerGap(170, Short.MAX_VALUE))
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

        SidePanel.add(btn_nuevo_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 60));

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
                .addComponent(icono5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unimet 2024 ®");
        SidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 690, -1, -1));

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SidePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 26));
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 80));

        btn_cargar_guardar.setBackground(new java.awt.Color(243, 168, 71));
        btn_cargar_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cargar_guardarMouseClicked(evt);
            }
        });
        btn_cargar_guardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icono7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono7MouseClicked(evt);
            }
        });
        btn_cargar_guardar.add(icono7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 14, -1, 32));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Configuración");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        btn_cargar_guardar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 14, -1, -1));

        SidePanel.add(btn_cargar_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 330, 60));

        jPanel1.add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 730));

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

        driveTitle.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        driveTitle.setForeground(new java.awt.Color(255, 255, 255));
        driveTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        driveTitle.setText("Configuracion de los parámetros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(driveTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(driveTitle)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 190));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(243, 168, 71));

        scripts1.setBackground(java.awt.Color.lightGray);
        scripts1.setForeground(new java.awt.Color(60, 63, 65));

        scriptsTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsTitle1.setForeground(new java.awt.Color(51, 51, 51));
        scriptsTitle1.setText("Duración de los días (seg):");

        increaseScripts1.setBackground(new java.awt.Color(51, 51, 51));
        increaseScripts1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScripts1.setForeground(new java.awt.Color(255, 255, 255));
        increaseScripts1.setText("+");
        increaseScripts1.setBorderPainted(false);
        increaseScripts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScripts1MouseClicked(evt);
            }
        });
        increaseScripts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScripts1ActionPerformed(evt);
            }
        });

        dayDuration.setBackground(java.awt.Color.lightGray);
        dayDuration.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dayDuration.setForeground(new java.awt.Color(51, 51, 51));
        dayDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayDuration.setText("0");
        dayDuration.setBorder(null);
        dayDuration.setFocusable(false);
        dayDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayDurationActionPerformed(evt);
            }
        });

        decreaseScripts1.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScripts1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScripts1.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScripts1.setText("-");
        decreaseScripts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScripts1MouseClicked(evt);
            }
        });
        decreaseScripts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScripts1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scripts1Layout = new javax.swing.GroupLayout(scripts1);
        scripts1.setLayout(scripts1Layout);
        scripts1Layout.setHorizontalGroup(
            scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scriptsTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseScripts1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(increaseScripts1)
                .addContainerGap())
        );
        scripts1Layout.setVerticalGroup(
            scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scriptsTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(increaseScripts1)
                .addComponent(dayDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(decreaseScripts1))
        );

        jButton1.setBackground(new java.awt.Color(34, 46, 60));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Assets/save_btn.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        scripts3.setBackground(java.awt.Color.lightGray);
        scripts3.setForeground(new java.awt.Color(60, 63, 65));

        scriptsTitle3.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsTitle3.setForeground(new java.awt.Color(51, 51, 51));
        scriptsTitle3.setText("Días entre las entregas:");

        increaseScripts3.setBackground(new java.awt.Color(51, 51, 51));
        increaseScripts3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScripts3.setForeground(new java.awt.Color(255, 255, 255));
        increaseScripts3.setText("+");
        increaseScripts3.setBorderPainted(false);
        increaseScripts3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScripts3MouseClicked(evt);
            }
        });
        increaseScripts3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScripts3ActionPerformed(evt);
            }
        });

        deadlineValue.setBackground(java.awt.Color.lightGray);
        deadlineValue.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        deadlineValue.setForeground(new java.awt.Color(51, 51, 51));
        deadlineValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deadlineValue.setText("0");
        deadlineValue.setBorder(null);
        deadlineValue.setFocusable(false);
        deadlineValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deadlineValueActionPerformed(evt);
            }
        });

        decreaseScripts3.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScripts3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScripts3.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScripts3.setText("-");
        decreaseScripts3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScripts3MouseClicked(evt);
            }
        });
        decreaseScripts3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScripts3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scripts3Layout = new javax.swing.GroupLayout(scripts3);
        scripts3.setLayout(scripts3Layout);
        scripts3Layout.setHorizontalGroup(
            scripts3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scriptsTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseScripts3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deadlineValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(increaseScripts3)
                .addGap(16, 16, 16))
        );
        scripts3Layout.setVerticalGroup(
            scripts3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scriptsTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(increaseScripts3)
                .addComponent(deadlineValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(decreaseScripts3))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scripts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scripts3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scripts3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scripts1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        workersConfigurations5.setBackground(new java.awt.Color(243, 168, 71));

        driveTitle11.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle11.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        scripts6.setBackground(java.awt.Color.lightGray);
        scripts6.setForeground(new java.awt.Color(60, 63, 65));

        scriptsTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsTitle6.setForeground(new java.awt.Color(51, 51, 51));
        scriptsTitle6.setText("Guionistas:");

        increaseScripts6.setBackground(new java.awt.Color(51, 51, 51));
        increaseScripts6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScripts6.setForeground(new java.awt.Color(255, 255, 255));
        increaseScripts6.setText("+");
        increaseScripts6.setBorderPainted(false);
        increaseScripts6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScripts6MouseClicked(evt);
            }
        });
        increaseScripts6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScripts6ActionPerformed(evt);
            }
        });

        scriptsValues1.setBackground(java.awt.Color.lightGray);
        scriptsValues1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsValues1.setForeground(new java.awt.Color(51, 51, 51));
        scriptsValues1.setText("0");
        scriptsValues1.setBorder(null);
        scriptsValues1.setFocusable(false);
        scriptsValues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptsValues1ActionPerformed(evt);
            }
        });

        decreaseScripts6.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScripts6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScripts6.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScripts6.setText("-");
        decreaseScripts6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScripts6MouseClicked(evt);
            }
        });
        decreaseScripts6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScripts6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scripts6Layout = new javax.swing.GroupLayout(scripts6);
        scripts6.setLayout(scripts6Layout);
        scripts6Layout.setHorizontalGroup(
            scripts6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scriptsTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(decreaseScripts6)
                .addGap(22, 22, 22)
                .addComponent(scriptsValues1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseScripts6)
                .addGap(14, 14, 14))
        );
        scripts6Layout.setVerticalGroup(
            scripts6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scriptsTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(increaseScripts6)
                .addComponent(scriptsValues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(decreaseScripts6))
        );

        scenary5.setBackground(java.awt.Color.lightGray);
        scenary5.setForeground(new java.awt.Color(60, 63, 65));

        scenaryTitle5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryTitle5.setForeground(new java.awt.Color(51, 51, 51));
        scenaryTitle5.setText("Escenarios:");
        scenaryTitle5.setMaximumSize(new java.awt.Dimension(88, 21));
        scenaryTitle5.setMinimumSize(new java.awt.Dimension(88, 21));

        scenaryValue1.setBackground(java.awt.Color.lightGray);
        scenaryValue1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryValue1.setForeground(new java.awt.Color(51, 51, 51));
        scenaryValue1.setText("0");
        scenaryValue1.setBorder(null);
        scenaryValue1.setFocusable(false);
        scenaryValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenaryValue1ActionPerformed(evt);
            }
        });

        increaseScenary5.setBackground(new java.awt.Color(51, 51, 51));
        increaseScenary5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScenary5.setForeground(new java.awt.Color(255, 255, 255));
        increaseScenary5.setText("+");
        increaseScenary5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScenary5MouseClicked(evt);
            }
        });
        increaseScenary5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScenary5ActionPerformed(evt);
            }
        });

        decreaseScenary5.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScenary5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScenary5.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScenary5.setText("-");
        decreaseScenary5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScenary5MouseClicked(evt);
            }
        });
        decreaseScenary5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScenary5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scenary5Layout = new javax.swing.GroupLayout(scenary5);
        scenary5.setLayout(scenary5Layout);
        scenary5Layout.setHorizontalGroup(
            scenary5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scenaryTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseScenary5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scenaryValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseScenary5)
                .addGap(15, 15, 15))
        );
        scenary5Layout.setVerticalGroup(
            scenary5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scenary5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scenaryTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreaseScenary5)
                    .addComponent(scenaryValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseScenary5))
                .addContainerGap())
        );

        animations5.setBackground(java.awt.Color.lightGray);
        animations5.setForeground(new java.awt.Color(255, 255, 255));

        animationsTitle5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationsTitle5.setForeground(new java.awt.Color(51, 51, 51));
        animationsTitle5.setText("Animador:");
        animationsTitle5.setMaximumSize(new java.awt.Dimension(88, 21));
        animationsTitle5.setMinimumSize(new java.awt.Dimension(88, 21));

        animationValues1.setBackground(java.awt.Color.lightGray);
        animationValues1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationValues1.setForeground(new java.awt.Color(51, 51, 51));
        animationValues1.setText("0");
        animationValues1.setBorder(null);
        animationValues1.setFocusable(false);
        animationValues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationValues1ActionPerformed(evt);
            }
        });

        decreaseAnimation5.setBackground(new java.awt.Color(51, 51, 51));
        decreaseAnimation5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseAnimation5.setForeground(new java.awt.Color(255, 255, 255));
        decreaseAnimation5.setText("-");
        decreaseAnimation5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseAnimation5MouseClicked(evt);
            }
        });
        decreaseAnimation5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseAnimation5ActionPerformed(evt);
            }
        });

        increaseAnimation5.setBackground(new java.awt.Color(51, 51, 51));
        increaseAnimation5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseAnimation5.setForeground(new java.awt.Color(255, 255, 255));
        increaseAnimation5.setText("+");
        increaseAnimation5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseAnimation5MouseClicked(evt);
            }
        });
        increaseAnimation5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseAnimation5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout animations5Layout = new javax.swing.GroupLayout(animations5);
        animations5.setLayout(animations5Layout);
        animations5Layout.setHorizontalGroup(
            animations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(animationsTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseAnimation5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animationValues1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseAnimation5)
                .addGap(17, 17, 17))
        );
        animations5Layout.setVerticalGroup(
            animations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animationsTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreaseAnimation5)
                    .addComponent(animationValues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseAnimation5))
                .addContainerGap())
        );

        dubbing5.setBackground(java.awt.Color.lightGray);
        dubbing5.setForeground(new java.awt.Color(255, 255, 255));

        dubbingTitle5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingTitle5.setForeground(new java.awt.Color(51, 51, 51));
        dubbingTitle5.setText("Doblaje:");
        dubbingTitle5.setMaximumSize(new java.awt.Dimension(88, 21));
        dubbingTitle5.setMinimumSize(new java.awt.Dimension(88, 21));

        decreaseDubbing5.setBackground(new java.awt.Color(51, 51, 51));
        decreaseDubbing5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseDubbing5.setForeground(new java.awt.Color(204, 204, 204));
        decreaseDubbing5.setText("-");
        decreaseDubbing5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseDubbing5MouseClicked(evt);
            }
        });
        decreaseDubbing5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseDubbing5ActionPerformed(evt);
            }
        });

        dubbingValues1.setBackground(java.awt.Color.lightGray);
        dubbingValues1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingValues1.setForeground(new java.awt.Color(51, 51, 51));
        dubbingValues1.setText("0");
        dubbingValues1.setBorder(null);
        dubbingValues1.setFocusable(false);
        dubbingValues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dubbingValues1ActionPerformed(evt);
            }
        });

        increaseDubbing5.setBackground(new java.awt.Color(51, 51, 51));
        increaseDubbing5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseDubbing5.setForeground(new java.awt.Color(255, 255, 255));
        increaseDubbing5.setText("+");
        increaseDubbing5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseDubbing5MouseClicked(evt);
            }
        });
        increaseDubbing5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseDubbing5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dubbing5Layout = new javax.swing.GroupLayout(dubbing5);
        dubbing5.setLayout(dubbing5Layout);
        dubbing5Layout.setHorizontalGroup(
            dubbing5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(dubbingTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseDubbing5)
                .addGap(18, 18, 18)
                .addComponent(dubbingValues1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseDubbing5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dubbing5Layout.setVerticalGroup(
            dubbing5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dubbing5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decreaseDubbing5)
                    .addComponent(dubbingValues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseDubbing5)
                    .addComponent(dubbingTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        plotTwist5.setBackground(java.awt.Color.lightGray);
        plotTwist5.setForeground(new java.awt.Color(255, 255, 255));
        plotTwist5.setFocusable(false);

        plotTwistTitle5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistTitle5.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistTitle5.setText("PlotTwist:");
        plotTwistTitle5.setMaximumSize(new java.awt.Dimension(88, 21));
        plotTwistTitle5.setMinimumSize(new java.awt.Dimension(88, 21));

        increasePlotTwist5.setBackground(new java.awt.Color(51, 51, 51));
        increasePlotTwist5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increasePlotTwist5.setForeground(new java.awt.Color(255, 255, 255));
        increasePlotTwist5.setText("+");
        increasePlotTwist5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increasePlotTwist5MouseClicked(evt);
            }
        });
        increasePlotTwist5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increasePlotTwist5ActionPerformed(evt);
            }
        });

        plotTwistValues1.setBackground(java.awt.Color.lightGray);
        plotTwistValues1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistValues1.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistValues1.setText("0");
        plotTwistValues1.setBorder(null);
        plotTwistValues1.setFocusable(false);
        plotTwistValues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistValues1ActionPerformed(evt);
            }
        });

        decreacePlotTwist5.setBackground(new java.awt.Color(51, 51, 51));
        decreacePlotTwist5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreacePlotTwist5.setForeground(new java.awt.Color(255, 255, 255));
        decreacePlotTwist5.setText("-");
        decreacePlotTwist5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreacePlotTwist5MouseClicked(evt);
            }
        });
        decreacePlotTwist5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreacePlotTwist5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plotTwist5Layout = new javax.swing.GroupLayout(plotTwist5);
        plotTwist5.setLayout(plotTwist5Layout);
        plotTwist5Layout.setHorizontalGroup(
            plotTwist5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotTwist5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(plotTwistTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreacePlotTwist5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plotTwistValues1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increasePlotTwist5)
                .addGap(20, 20, 20))
        );
        plotTwist5Layout.setVerticalGroup(
            plotTwist5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotTwist5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plotTwist5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(increasePlotTwist5)
                    .addComponent(plotTwistValues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreacePlotTwist5)
                    .addComponent(plotTwistTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        driveTitle12.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        driveTitle12.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        driveTitle12.setText("Cartoon Network");

        javax.swing.GroupLayout workersConfigurations5Layout = new javax.swing.GroupLayout(workersConfigurations5);
        workersConfigurations5.setLayout(workersConfigurations5Layout);
        workersConfigurations5Layout.setHorizontalGroup(
            workersConfigurations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurations5Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(driveTitle11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(workersConfigurations5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(workersConfigurations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workersConfigurations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(animations5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dubbing5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plotTwist5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scenary5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scripts6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(driveTitle12, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workersConfigurations5Layout.setVerticalGroup(
            workersConfigurations5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurations5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(driveTitle12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(driveTitle11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scripts6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scenary5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(animations5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dubbing5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotTwist5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        workersConfigurations6.setBackground(new java.awt.Color(243, 168, 71));

        driveTitle13.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle13.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        scripts7.setBackground(java.awt.Color.lightGray);
        scripts7.setForeground(new java.awt.Color(60, 63, 65));

        scriptsTitle7.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsTitle7.setForeground(new java.awt.Color(51, 51, 51));
        scriptsTitle7.setText("Guionistas:");

        increaseScripts7.setBackground(new java.awt.Color(51, 51, 51));
        increaseScripts7.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScripts7.setForeground(new java.awt.Color(255, 255, 255));
        increaseScripts7.setText("+");
        increaseScripts7.setBorderPainted(false);
        increaseScripts7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScripts7MouseClicked(evt);
            }
        });
        increaseScripts7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScripts7ActionPerformed(evt);
            }
        });

        scriptsValues0.setBackground(java.awt.Color.lightGray);
        scriptsValues0.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsValues0.setForeground(new java.awt.Color(51, 51, 51));
        scriptsValues0.setText("0");
        scriptsValues0.setBorder(null);
        scriptsValues0.setFocusable(false);
        scriptsValues0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptsValues0ActionPerformed(evt);
            }
        });

        decreaseScripts.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScripts.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScripts.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScripts.setText("-");
        decreaseScripts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScriptsMouseClicked(evt);
            }
        });
        decreaseScripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScriptsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scripts7Layout = new javax.swing.GroupLayout(scripts7);
        scripts7.setLayout(scripts7Layout);
        scripts7Layout.setHorizontalGroup(
            scripts7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scriptsTitle7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(decreaseScripts)
                .addGap(22, 22, 22)
                .addComponent(scriptsValues0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseScripts7)
                .addGap(14, 14, 14))
        );
        scripts7Layout.setVerticalGroup(
            scripts7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scriptsTitle7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(increaseScripts7)
                .addComponent(scriptsValues0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(decreaseScripts))
        );

        scenary6.setBackground(java.awt.Color.lightGray);
        scenary6.setForeground(new java.awt.Color(60, 63, 65));

        scenaryTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryTitle6.setForeground(new java.awt.Color(51, 51, 51));
        scenaryTitle6.setText("Escenarios:");
        scenaryTitle6.setMaximumSize(new java.awt.Dimension(88, 21));
        scenaryTitle6.setMinimumSize(new java.awt.Dimension(88, 21));

        scenaryValue0.setBackground(java.awt.Color.lightGray);
        scenaryValue0.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryValue0.setForeground(new java.awt.Color(51, 51, 51));
        scenaryValue0.setText("0");
        scenaryValue0.setBorder(null);
        scenaryValue0.setFocusable(false);
        scenaryValue0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenaryValue0ActionPerformed(evt);
            }
        });

        increaseScenary6.setBackground(new java.awt.Color(51, 51, 51));
        increaseScenary6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScenary6.setForeground(new java.awt.Color(255, 255, 255));
        increaseScenary6.setText("+");
        increaseScenary6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScenary6MouseClicked(evt);
            }
        });
        increaseScenary6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScenary6ActionPerformed(evt);
            }
        });

        decreaseScenary6.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScenary6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScenary6.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScenary6.setText("-");
        decreaseScenary6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScenary6MouseClicked(evt);
            }
        });
        decreaseScenary6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScenary6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scenary6Layout = new javax.swing.GroupLayout(scenary6);
        scenary6.setLayout(scenary6Layout);
        scenary6Layout.setHorizontalGroup(
            scenary6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scenaryTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseScenary6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scenaryValue0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseScenary6)
                .addGap(15, 15, 15))
        );
        scenary6Layout.setVerticalGroup(
            scenary6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scenary6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scenaryTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreaseScenary6)
                    .addComponent(scenaryValue0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseScenary6))
                .addContainerGap())
        );

        animations6.setBackground(java.awt.Color.lightGray);
        animations6.setForeground(new java.awt.Color(255, 255, 255));

        animationsTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationsTitle6.setForeground(new java.awt.Color(51, 51, 51));
        animationsTitle6.setText("Animador:");
        animationsTitle6.setMaximumSize(new java.awt.Dimension(88, 21));
        animationsTitle6.setMinimumSize(new java.awt.Dimension(88, 21));

        animationValues0.setBackground(java.awt.Color.lightGray);
        animationValues0.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationValues0.setForeground(new java.awt.Color(51, 51, 51));
        animationValues0.setText("0");
        animationValues0.setBorder(null);
        animationValues0.setFocusable(false);
        animationValues0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationValues0ActionPerformed(evt);
            }
        });

        decreaseAnimation6.setBackground(new java.awt.Color(51, 51, 51));
        decreaseAnimation6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseAnimation6.setForeground(new java.awt.Color(255, 255, 255));
        decreaseAnimation6.setText("-");
        decreaseAnimation6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseAnimation6MouseClicked(evt);
            }
        });
        decreaseAnimation6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseAnimation6ActionPerformed(evt);
            }
        });

        increaseAnimation6.setBackground(new java.awt.Color(51, 51, 51));
        increaseAnimation6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseAnimation6.setForeground(new java.awt.Color(255, 255, 255));
        increaseAnimation6.setText("+");
        increaseAnimation6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseAnimation6MouseClicked(evt);
            }
        });
        increaseAnimation6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseAnimation6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout animations6Layout = new javax.swing.GroupLayout(animations6);
        animations6.setLayout(animations6Layout);
        animations6Layout.setHorizontalGroup(
            animations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(animationsTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseAnimation6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animationValues0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseAnimation6)
                .addGap(17, 17, 17))
        );
        animations6Layout.setVerticalGroup(
            animations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animationsTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreaseAnimation6)
                    .addComponent(animationValues0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseAnimation6))
                .addContainerGap())
        );

        dubbing6.setBackground(java.awt.Color.lightGray);
        dubbing6.setForeground(new java.awt.Color(255, 255, 255));

        dubbingTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingTitle6.setForeground(new java.awt.Color(51, 51, 51));
        dubbingTitle6.setText("Doblaje:");
        dubbingTitle6.setMaximumSize(new java.awt.Dimension(88, 21));
        dubbingTitle6.setMinimumSize(new java.awt.Dimension(88, 21));

        decreaseDubbing6.setBackground(new java.awt.Color(51, 51, 51));
        decreaseDubbing6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseDubbing6.setForeground(new java.awt.Color(204, 204, 204));
        decreaseDubbing6.setText("-");
        decreaseDubbing6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseDubbing6MouseClicked(evt);
            }
        });
        decreaseDubbing6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseDubbing6ActionPerformed(evt);
            }
        });

        dubbingValues0.setBackground(java.awt.Color.lightGray);
        dubbingValues0.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingValues0.setForeground(new java.awt.Color(51, 51, 51));
        dubbingValues0.setText("0");
        dubbingValues0.setBorder(null);
        dubbingValues0.setFocusable(false);
        dubbingValues0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dubbingValues0ActionPerformed(evt);
            }
        });

        increaseDubbing6.setBackground(new java.awt.Color(51, 51, 51));
        increaseDubbing6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseDubbing6.setForeground(new java.awt.Color(255, 255, 255));
        increaseDubbing6.setText("+");
        increaseDubbing6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseDubbing6MouseClicked(evt);
            }
        });
        increaseDubbing6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseDubbing6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dubbing6Layout = new javax.swing.GroupLayout(dubbing6);
        dubbing6.setLayout(dubbing6Layout);
        dubbing6Layout.setHorizontalGroup(
            dubbing6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(dubbingTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreaseDubbing6)
                .addGap(18, 18, 18)
                .addComponent(dubbingValues0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increaseDubbing6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dubbing6Layout.setVerticalGroup(
            dubbing6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dubbing6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decreaseDubbing6)
                    .addComponent(dubbingValues0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(increaseDubbing6)
                    .addComponent(dubbingTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        plotTwist6.setBackground(java.awt.Color.lightGray);
        plotTwist6.setForeground(new java.awt.Color(255, 255, 255));

        plotTwistTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistTitle6.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistTitle6.setText("PlotTwist:");
        plotTwistTitle6.setMaximumSize(new java.awt.Dimension(88, 21));
        plotTwistTitle6.setMinimumSize(new java.awt.Dimension(88, 21));

        increasePlotTwist6.setBackground(new java.awt.Color(51, 51, 51));
        increasePlotTwist6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increasePlotTwist6.setForeground(new java.awt.Color(255, 255, 255));
        increasePlotTwist6.setText("+");
        increasePlotTwist6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increasePlotTwist6MouseClicked(evt);
            }
        });
        increasePlotTwist6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increasePlotTwist6ActionPerformed(evt);
            }
        });

        plotTwistValues0.setBackground(java.awt.Color.lightGray);
        plotTwistValues0.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistValues0.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistValues0.setText("0");
        plotTwistValues0.setBorder(null);
        plotTwistValues0.setFocusable(false);
        plotTwistValues0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistValues0ActionPerformed(evt);
            }
        });

        decreacePlotTwist6.setBackground(new java.awt.Color(51, 51, 51));
        decreacePlotTwist6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreacePlotTwist6.setForeground(new java.awt.Color(255, 255, 255));
        decreacePlotTwist6.setText("-");
        decreacePlotTwist6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreacePlotTwist6MouseClicked(evt);
            }
        });
        decreacePlotTwist6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreacePlotTwist6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plotTwist6Layout = new javax.swing.GroupLayout(plotTwist6);
        plotTwist6.setLayout(plotTwist6Layout);
        plotTwist6Layout.setHorizontalGroup(
            plotTwist6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotTwist6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(plotTwistTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decreacePlotTwist6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plotTwistValues0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(increasePlotTwist6)
                .addGap(20, 20, 20))
        );
        plotTwist6Layout.setVerticalGroup(
            plotTwist6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotTwist6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plotTwist6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(increasePlotTwist6)
                    .addComponent(plotTwistValues0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decreacePlotTwist6)
                    .addComponent(plotTwistTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        driveTitle14.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        driveTitle14.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        driveTitle14.setText("Nickelodeon");

        javax.swing.GroupLayout workersConfigurations6Layout = new javax.swing.GroupLayout(workersConfigurations6);
        workersConfigurations6.setLayout(workersConfigurations6Layout);
        workersConfigurations6Layout.setHorizontalGroup(
            workersConfigurations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurations6Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(driveTitle13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(workersConfigurations6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(workersConfigurations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workersConfigurations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(animations6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dubbing6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plotTwist6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scenary6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scripts7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(driveTitle14, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workersConfigurations6Layout.setVerticalGroup(
            workersConfigurations6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurations6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(driveTitle14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(driveTitle13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scripts7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scenary6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(animations6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dubbing6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotTwist6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(workersConfigurations6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(workersConfigurations5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(workersConfigurations6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(workersConfigurations5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 870, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
        int x = getLocation().x - initialClick.x + evt.getX();
        int y = getLocation().y - initialClick.y + evt.getY();
        setLocation(x, y);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void btn_cargar_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargar_guardarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_cargar_guardarMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel10MouseClicked

    private void icono7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_icono7MouseClicked

    private void btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reporteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reporteMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void icono5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icono5MouseClicked

    private void btn_nuevo_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_almacenMouseClicked
        // TODO add your handling code here:
        nickelodeon.setVisible(true);
        nickelodeon.setLocationRelativeTo(null);
        nickelodeon.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/nickelodeonTheme.wav");
        this.setVisible(false);
    }//GEN-LAST:event_btn_nuevo_almacenMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        nickelodeon.setVisible(true);
        nickelodeon.setLocationRelativeTo(null);
        nickelodeon.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/nickelodeonTheme.wav");
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void icono4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_icono4MouseClicked

    private void btn_nueva_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nueva_rutaMouseClicked
        // TODO add your handling code here:
        cartoonNetwork.setVisible(true);
        cartoonNetwork.setLocationRelativeTo(null);
        cartoonNetwork.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/cartoonNetworkTheme.wav");
        this.setVisible(false);
    }//GEN-LAST:event_btn_nueva_rutaMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        cartoonNetwork.setVisible(true);
        cartoonNetwork.setLocationRelativeTo(null);
        cartoonNetwork.setResizable(false);
        cartoonPlayMusic("/GUI/Assets/cartoonNetworkTheme.wav");
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void icono3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_icono3MouseClicked

    private void btn_nuevo_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_pedidoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_nuevo_pedidoMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel5MouseClicked

    private void increaseScripts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScripts1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts1MouseClicked

    private void increaseScripts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScripts1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts1ActionPerformed

    private void dayDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayDurationActionPerformed

    private void decreaseScripts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScripts1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts1MouseClicked

    private void decreaseScripts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScripts1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try {
            this.filefunctions.write(this.selectedFile);
            JOptionPane.showMessageDialog(this, "El archivo ha sido guardado exitosamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al escribir el archivo");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void increaseScripts6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScripts6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts6MouseClicked

    private void increaseScripts6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScripts6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts6ActionPerformed

    private void scriptsValues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptsValues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scriptsValues1ActionPerformed

    private void decreaseScripts6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScripts6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts6MouseClicked

    private void decreaseScripts6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScripts6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts6ActionPerformed

    private void scenaryValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scenaryValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scenaryValue1ActionPerformed

    private void increaseScenary5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScenary5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScenary5MouseClicked

    private void increaseScenary5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScenary5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScenary5ActionPerformed

    private void decreaseScenary5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScenary5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScenary5MouseClicked

    private void decreaseScenary5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScenary5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScenary5ActionPerformed

    private void animationValues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationValues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animationValues1ActionPerformed

    private void decreaseAnimation5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseAnimation5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseAnimation5MouseClicked

    private void decreaseAnimation5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseAnimation5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseAnimation5ActionPerformed

    private void increaseAnimation5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseAnimation5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseAnimation5MouseClicked

    private void increaseAnimation5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseAnimation5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseAnimation5ActionPerformed

    private void decreaseDubbing5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseDubbing5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseDubbing5MouseClicked

    private void decreaseDubbing5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseDubbing5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseDubbing5ActionPerformed

    private void dubbingValues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dubbingValues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dubbingValues1ActionPerformed

    private void increaseDubbing5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseDubbing5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseDubbing5MouseClicked

    private void increaseDubbing5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseDubbing5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseDubbing5ActionPerformed

    private void increasePlotTwist5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increasePlotTwist5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increasePlotTwist5MouseClicked

    private void increasePlotTwist5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increasePlotTwist5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increasePlotTwist5ActionPerformed

    private void plotTwistValues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistValues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistValues1ActionPerformed

    private void decreacePlotTwist5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreacePlotTwist5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreacePlotTwist5MouseClicked

    private void decreacePlotTwist5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreacePlotTwist5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreacePlotTwist5ActionPerformed

    private void increaseScripts3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScripts3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts3MouseClicked

    private void increaseScripts3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScripts3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts3ActionPerformed

    private void deadlineValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deadlineValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deadlineValueActionPerformed

    private void decreaseScripts3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScripts3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts3MouseClicked

    private void decreaseScripts3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScripts3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScripts3ActionPerformed

    private void increaseScripts7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScripts7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts7MouseClicked

    private void increaseScripts7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScripts7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScripts7ActionPerformed

    private void scriptsValues0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptsValues0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scriptsValues0ActionPerformed

    private void decreaseScriptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScriptsMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 0);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav");
        this.scriptsValues0.setText(decreaseQuantity(this.scriptsValues0.getText()));


    }//GEN-LAST:event_decreaseScriptsMouseClicked

    private void decreaseScriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScriptsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScriptsActionPerformed

    private void scenaryValue0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scenaryValue0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scenaryValue0ActionPerformed

    private void increaseScenary6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScenary6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScenary6MouseClicked

    private void increaseScenary6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScenary6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScenary6ActionPerformed

    private void decreaseScenary6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScenary6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScenary6MouseClicked

    private void decreaseScenary6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScenary6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScenary6ActionPerformed

    private void animationValues0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationValues0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animationValues0ActionPerformed

    private void decreaseAnimation6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseAnimation6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseAnimation6MouseClicked

    private void decreaseAnimation6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseAnimation6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseAnimation6ActionPerformed

    private void increaseAnimation6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseAnimation6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseAnimation6MouseClicked

    private void increaseAnimation6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseAnimation6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseAnimation6ActionPerformed

    private void decreaseDubbing6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseDubbing6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseDubbing6MouseClicked

    private void decreaseDubbing6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseDubbing6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseDubbing6ActionPerformed

    private void dubbingValues0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dubbingValues0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dubbingValues0ActionPerformed

    private void increaseDubbing6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseDubbing6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseDubbing6MouseClicked

    private void increaseDubbing6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseDubbing6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseDubbing6ActionPerformed

    private void increasePlotTwist6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increasePlotTwist6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_increasePlotTwist6MouseClicked

    private void increasePlotTwist6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increasePlotTwist6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increasePlotTwist6ActionPerformed

    private void plotTwistValues0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistValues0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistValues0ActionPerformed

    private void decreacePlotTwist6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreacePlotTwist6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_decreacePlotTwist6MouseClicked

    private void decreacePlotTwist6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreacePlotTwist6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreacePlotTwist6ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Home v1 = new Home();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_InicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InicioMouseClicked
        // TODO add your handling code here:
        Home v1 = new Home();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_InicioMouseClicked

    private String decreaseQuantity(String actualValue, JButton button) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(actualValue);
            if (intValue > 0) {
                intValue--;
                actualEmployees--;
                if  {
                    return String.valueOf(intValue);
                }
            } else {
                return String.valueOf(intValue);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el valor a int: " + e.getMessage());
        }
        return null;
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
            java.util.logging.Logger.getLogger(ConfigParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigParams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField animationValues0;
    private javax.swing.JTextField animationValues1;
    private javax.swing.JPanel animations5;
    private javax.swing.JPanel animations6;
    private javax.swing.JLabel animationsTitle5;
    private javax.swing.JLabel animationsTitle6;
    private javax.swing.JPanel btn_Inicio;
    private javax.swing.JPanel btn_cargar_guardar;
    private javax.swing.JPanel btn_nueva_ruta;
    private javax.swing.JPanel btn_nuevo_almacen;
    private javax.swing.JPanel btn_nuevo_pedido;
    private javax.swing.JPanel btn_reporte;
    private javax.swing.JTextField dayDuration;
    private javax.swing.JTextField deadlineValue;
    private javax.swing.JButton decreacePlotTwist5;
    private javax.swing.JButton decreacePlotTwist6;
    private javax.swing.JButton decreaseAnimation5;
    private javax.swing.JButton decreaseAnimation6;
    private javax.swing.JButton decreaseDubbing5;
    private javax.swing.JButton decreaseDubbing6;
    private javax.swing.JButton decreaseScenary5;
    private javax.swing.JButton decreaseScenary6;
    private javax.swing.JButton decreaseScripts;
    private javax.swing.JButton decreaseScripts1;
    private javax.swing.JButton decreaseScripts3;
    private javax.swing.JButton decreaseScripts6;
    private javax.swing.JLabel driveTitle;
    private javax.swing.JLabel driveTitle11;
    private javax.swing.JLabel driveTitle12;
    private javax.swing.JLabel driveTitle13;
    private javax.swing.JLabel driveTitle14;
    private javax.swing.JPanel dubbing5;
    private javax.swing.JPanel dubbing6;
    private javax.swing.JLabel dubbingTitle5;
    private javax.swing.JLabel dubbingTitle6;
    private javax.swing.JTextField dubbingValues0;
    private javax.swing.JTextField dubbingValues1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel icono3;
    private javax.swing.JLabel icono4;
    private javax.swing.JLabel icono5;
    private javax.swing.JLabel icono7;
    private javax.swing.JButton increaseAnimation5;
    private javax.swing.JButton increaseAnimation6;
    private javax.swing.JButton increaseDubbing5;
    private javax.swing.JButton increaseDubbing6;
    private javax.swing.JButton increasePlotTwist5;
    private javax.swing.JButton increasePlotTwist6;
    private javax.swing.JButton increaseScenary5;
    private javax.swing.JButton increaseScenary6;
    private javax.swing.JButton increaseScripts1;
    private javax.swing.JButton increaseScripts3;
    private javax.swing.JButton increaseScripts6;
    private javax.swing.JButton increaseScripts7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel plotTwist5;
    private javax.swing.JPanel plotTwist6;
    private javax.swing.JLabel plotTwistTitle5;
    private javax.swing.JLabel plotTwistTitle6;
    private javax.swing.JTextField plotTwistValues0;
    private javax.swing.JTextField plotTwistValues1;
    private javax.swing.JPanel scenary5;
    private javax.swing.JPanel scenary6;
    private javax.swing.JLabel scenaryTitle5;
    private javax.swing.JLabel scenaryTitle6;
    private javax.swing.JTextField scenaryValue0;
    private javax.swing.JTextField scenaryValue1;
    private javax.swing.JPanel scripts1;
    private javax.swing.JPanel scripts3;
    private javax.swing.JPanel scripts6;
    private javax.swing.JPanel scripts7;
    private javax.swing.JLabel scriptsTitle1;
    private javax.swing.JLabel scriptsTitle3;
    private javax.swing.JLabel scriptsTitle6;
    private javax.swing.JLabel scriptsTitle7;
    private javax.swing.JTextField scriptsValues0;
    private javax.swing.JTextField scriptsValues1;
    private javax.swing.JPanel workersConfigurations5;
    private javax.swing.JPanel workersConfigurations6;
    // End of variables declaration//GEN-END:variables
}
