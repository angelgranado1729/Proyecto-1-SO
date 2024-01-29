/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Classes;
import MainPackage.App;
import static MainPackage.App.getApp;
import static MainPackage.App.setApp;
import Helpers.HelpersFunctions;
import MainClasses.Employee;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author Erika A. Hernández Z.
 */
public class CartoonNetwork extends javax.swing.JFrame {
    
    private Point initialClick;
    private final App app = App.getInstance();
    private int maxEmployees;
    private int actualEmployees;
    private static CartoonNetwork cartoonNetwork;
    private HelpersFunctions helper = new HelpersFunctions();


    public static synchronized CartoonNetwork getInstance() {
        if (cartoonNetwork == null) {
            cartoonNetwork = new CartoonNetwork();
        }
        return cartoonNetwork;
    }

    public CartoonNetwork() {
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
        this.start();
    }
//    
    private void start() {
    // Crear un nuevo hilo para el bucle infinito
    Thread updateThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    // Ejecutar las actualizaciones de la UI en el EDT
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // Aquí van tus actualizaciones de la UI
                            scriptDrive.setText(String.valueOf(app.getCartoonNetwork().getDrive().getSections()[0]));
                            scenaryDrive.setText(String.valueOf(app.getCartoonNetwork().getDrive().getSections()[1]));
                            animationDrive.setText(String.valueOf(app.getCartoonNetwork().getDrive().getSections()[2]));
                            dubbingDrive.setText(String.valueOf(app.getCartoonNetwork().getDrive().getSections()[3]));
                            plotTwistDrive.setText(String.valueOf(app.getCartoonNetwork().getDrive().getSections()[4]));
                            projectManagerStatus.setText(app.getCartoonNetwork().getProjectManagerInstance().getCurrentState());
                            remainingDays.setText(String.valueOf(app.getCartoonNetwork().getRemainingDays()));
                            currentDays.setText(String.valueOf(app.getCartoonNetwork().getDaySet() - app.getCartoonNetwork().getRemainingDays()));
                            strikeCounter.setText(String.valueOf(app.getCartoonNetwork().getProjectManagerInstance().getStrikes()));
                            cashPenality.setText(String.valueOf(Integer.parseInt(strikeCounter.getText()) * 100));
                            directorStatus.setText(app.getCartoonNetwork().getDirectorInstance().getStatus());
                            standardChaptes.setText(String.valueOf(app.getCartoonNetwork().getDrive().getStandarChapters()));
                            plotTwistChapters.setText(String.valueOf(app.getCartoonNetwork().getDrive().getPlotTwistChapters()));
                            cost.setText(formatNumberAsK(app.getCartoonNetwork().getDrive().getCost()));
                            profit.setText((canUpdateProfit()));
                            earning.setText((canUpdateEarning()));
                        }
                    });

                    // Pausar el hilo separado, no el EDT
                    Thread.sleep(app.getDayDuration()/48);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // Opcionalmente, podrías salir del bucle si el hilo es interrumpido
                    break;
                }
            }
        }
    });

    // Iniciar el hilo
    updateThread.start();
}


        private void initializeValues() {
            if (this.app.getCartoonNetwork() != null) {
                this.maxEmployees = this.app.getCartoonNetwork().getMaxEmployeesQuantity();
                this.actualEmployees = this.app.getCartoonNetwork().getActualEmployeesQuantity();
                this.scriptsValues.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getScreenwriters())));
                this.scenaryValue.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getSetDesigners())));
                this.animationValues.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getCharacterAnimators())));
                this.dubbingValues.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getVoiceActors())));
                this.plotTwistValues.setText(String.valueOf(countNonNullEmployees(this.app.getCartoonNetwork().getPlotTwistScreenwriters())));
                
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

    public String formatNumberAsK(int number) {
        // Se onverte el número a miles
        double thousands = number / 1000.0;
        
        // Se redondea a dos dígitos significativos
        double rounded = Math.round(thousands * 100.0) / 100.0;

        // Se convierte a cadena y se añade 'K'
        return rounded + "K";
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
     
    private String canUpdateProfit(){
        if(this.app.getCartoonNetwork().getRemainingDays()==0){
            return String.valueOf(this.app.getCartoonNetwork().getProfit());
        } else{
            return "En " + String.valueOf(this.app.getCartoonNetwork().getRemainingDays()) + " días";
        }
    }
    
     private String canUpdateEarning(){
        if(this.app.getCartoonNetwork().getRemainingDays()==0){
            return String.valueOf(this.app.getCartoonNetwork().getEarning());
        } else{
            return "En " + String.valueOf(this.app.getCartoonNetwork().getRemainingDays()) + " días";
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
        btn_cargar_guardar = new javax.swing.JPanel();
        icono7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        workersConfigurations = new javax.swing.JPanel();
        driveTitle = new javax.swing.JLabel();
        driveTitle1 = new javax.swing.JLabel();
        scripts = new javax.swing.JPanel();
        scriptsTitle = new javax.swing.JLabel();
        decreaseScripts = new javax.swing.JButton();
        increaseScripts = new javax.swing.JButton();
        scriptsValues = new javax.swing.JTextField();
        scenary = new javax.swing.JPanel();
        scenaryTitle = new javax.swing.JLabel();
        scenaryValue = new javax.swing.JTextField();
        increaseScenary = new javax.swing.JButton();
        decreaseScenary = new javax.swing.JButton();
        animations = new javax.swing.JPanel();
        animationsTitle = new javax.swing.JLabel();
        animationValues = new javax.swing.JTextField();
        increaseAnimation = new javax.swing.JButton();
        decreaseAnimation = new javax.swing.JButton();
        dubbing = new javax.swing.JPanel();
        dubbingTitle = new javax.swing.JLabel();
        decreaseDubbing = new javax.swing.JButton();
        increaseDubbing = new javax.swing.JButton();
        dubbingValues = new javax.swing.JTextField();
        plotTwist = new javax.swing.JPanel();
        plotTwistTitle = new javax.swing.JLabel();
        increasePlotTwist = new javax.swing.JButton();
        decreacePlotTwist = new javax.swing.JButton();
        plotTwistValues = new javax.swing.JTextField();
        drivePanel = new javax.swing.JPanel();
        driveTitle2 = new javax.swing.JLabel();
        driveTitle3 = new javax.swing.JLabel();
        scripts1 = new javax.swing.JPanel();
        scriptTitle1 = new javax.swing.JLabel();
        scriptsLimit1 = new javax.swing.JLabel();
        scriptDrive = new javax.swing.JTextField();
        scenary1 = new javax.swing.JPanel();
        scenaryTitle1 = new javax.swing.JLabel();
        scenaryLimit1 = new javax.swing.JLabel();
        scenaryDrive = new javax.swing.JTextField();
        animations1 = new javax.swing.JPanel();
        animationsTitle1 = new javax.swing.JLabel();
        animationsLimit1 = new javax.swing.JLabel();
        animationDrive = new javax.swing.JTextField();
        dubbing1 = new javax.swing.JPanel();
        dubbingTitle1 = new javax.swing.JLabel();
        dubbingLimit1 = new javax.swing.JLabel();
        dubbingDrive = new javax.swing.JTextField();
        plotTwist1 = new javax.swing.JPanel();
        plotTwistLimit1 = new javax.swing.JLabel();
        plotTwistTitle1 = new javax.swing.JLabel();
        plotTwistDrive = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        driveTitle4 = new javax.swing.JLabel();
        driveTitle5 = new javax.swing.JLabel();
        driveTitle7 = new javax.swing.JLabel();
        plotTwistChapters = new javax.swing.JTextField();
        standardChaptes = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        driveTitle6 = new javax.swing.JLabel();
        driveTitle8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        driveTitle19 = new javax.swing.JLabel();
        driveTitle20 = new javax.swing.JLabel();
        currentDays = new javax.swing.JTextField();
        remainingDays = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        driveTitle9 = new javax.swing.JLabel();
        driveTitle10 = new javax.swing.JLabel();
        driveTitle11 = new javax.swing.JLabel();
        driveTitle17 = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        earning = new javax.swing.JTextField();
        profit = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        driveTitle14 = new javax.swing.JLabel();
        driveTitle18 = new javax.swing.JLabel();
        directorStatus = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        driveTitle15 = new javax.swing.JLabel();
        driveTitle12 = new javax.swing.JLabel();
        driveTitle13 = new javax.swing.JLabel();
        driveTitle16 = new javax.swing.JLabel();
        projectManagerStatus = new javax.swing.JTextField();
        strikeCounter = new javax.swing.JTextField();
        cashPenality = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePanel.setBackground(new java.awt.Color(34, 46, 60));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Inicio.setBackground(new java.awt.Color(55, 71, 90));

        icono1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
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
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
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

        btn_nueva_ruta.setBackground(new java.awt.Color(243, 168, 71));
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
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
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
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(icono4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
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
                .addComponent(icono7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
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

        jPanel1.add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 710));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Assets/cartoonLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel2)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 190));

        workersConfigurations.setBackground(new java.awt.Color(243, 168, 71));

        driveTitle.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle.setText("CONFIGURACIÓN");

        driveTitle1.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle1.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle1.setText("TRABAJADORES");

        scripts.setBackground(java.awt.Color.lightGray);
        scripts.setForeground(new java.awt.Color(60, 63, 65));

        scriptsTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsTitle.setForeground(new java.awt.Color(51, 51, 51));
        scriptsTitle.setText("Guionistas:");

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

        increaseScripts.setBackground(new java.awt.Color(51, 51, 51));
        increaseScripts.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScripts.setForeground(new java.awt.Color(255, 255, 255));
        increaseScripts.setText("+");
        increaseScripts.setBorderPainted(false);
        increaseScripts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScriptsMouseClicked(evt);
            }
        });
        increaseScripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScriptsActionPerformed(evt);
            }
        });

        scriptsValues.setBackground(java.awt.Color.lightGray);
        scriptsValues.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsValues.setForeground(new java.awt.Color(51, 51, 51));
        scriptsValues.setText("0");
        scriptsValues.setBorder(null);
        scriptsValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptsValuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scriptsLayout = new javax.swing.GroupLayout(scripts);
        scripts.setLayout(scriptsLayout);
        scriptsLayout.setHorizontalGroup(
            scriptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scriptsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(increaseScripts)
                .addGap(18, 18, 18)
                .addComponent(scriptsValues, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseScripts)
                .addGap(15, 15, 15))
        );
        scriptsLayout.setVerticalGroup(
            scriptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(scriptsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(decreaseScripts)
                .addComponent(increaseScripts)
                .addComponent(scriptsValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scenary.setBackground(java.awt.Color.lightGray);
        scenary.setForeground(new java.awt.Color(60, 63, 65));

        scenaryTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryTitle.setForeground(new java.awt.Color(51, 51, 51));
        scenaryTitle.setText("Escenarios:");

        scenaryValue.setBackground(java.awt.Color.lightGray);
        scenaryValue.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryValue.setForeground(new java.awt.Color(51, 51, 51));
        scenaryValue.setText("0");
        scenaryValue.setBorder(null);
        scenaryValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenaryValueActionPerformed(evt);
            }
        });

        increaseScenary.setBackground(new java.awt.Color(51, 51, 51));
        increaseScenary.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseScenary.setForeground(new java.awt.Color(255, 255, 255));
        increaseScenary.setText("+");
        increaseScenary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseScenaryMouseClicked(evt);
            }
        });
        increaseScenary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScenaryActionPerformed(evt);
            }
        });

        decreaseScenary.setBackground(new java.awt.Color(51, 51, 51));
        decreaseScenary.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseScenary.setForeground(new java.awt.Color(255, 255, 255));
        decreaseScenary.setText("-");
        decreaseScenary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseScenaryMouseClicked(evt);
            }
        });
        decreaseScenary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScenaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scenaryLayout = new javax.swing.GroupLayout(scenary);
        scenary.setLayout(scenaryLayout);
        scenaryLayout.setHorizontalGroup(
            scenaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenaryLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scenaryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(increaseScenary)
                .addGap(18, 18, 18)
                .addComponent(scenaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseScenary)
                .addGap(14, 14, 14))
        );
        scenaryLayout.setVerticalGroup(
            scenaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scenaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scenaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decreaseScenary)
                        .addComponent(increaseScenary)
                        .addComponent(scenaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scenaryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        animations.setBackground(java.awt.Color.lightGray);
        animations.setForeground(new java.awt.Color(255, 255, 255));

        animationsTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationsTitle.setForeground(new java.awt.Color(51, 51, 51));
        animationsTitle.setText("Animador:");

        animationValues.setBackground(java.awt.Color.lightGray);
        animationValues.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationValues.setForeground(new java.awt.Color(51, 51, 51));
        animationValues.setText("0");
        animationValues.setBorder(null);
        animationValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationValuesActionPerformed(evt);
            }
        });

        increaseAnimation.setBackground(new java.awt.Color(51, 51, 51));
        increaseAnimation.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseAnimation.setForeground(new java.awt.Color(255, 255, 255));
        increaseAnimation.setText("+");
        increaseAnimation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseAnimationMouseClicked(evt);
            }
        });
        increaseAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseAnimationActionPerformed(evt);
            }
        });

        decreaseAnimation.setBackground(new java.awt.Color(51, 51, 51));
        decreaseAnimation.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseAnimation.setForeground(new java.awt.Color(255, 255, 255));
        decreaseAnimation.setText("-");
        decreaseAnimation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseAnimationMouseClicked(evt);
            }
        });
        decreaseAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseAnimationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout animationsLayout = new javax.swing.GroupLayout(animations);
        animations.setLayout(animationsLayout);
        animationsLayout.setHorizontalGroup(
            animationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animationsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(animationsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(increaseAnimation)
                .addGap(18, 18, 18)
                .addComponent(animationValues, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseAnimation)
                .addGap(15, 15, 15))
        );
        animationsLayout.setVerticalGroup(
            animationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(animationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decreaseAnimation)
                        .addComponent(increaseAnimation)
                        .addComponent(animationValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(animationsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dubbing.setBackground(java.awt.Color.lightGray);
        dubbing.setForeground(new java.awt.Color(255, 255, 255));

        dubbingTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingTitle.setForeground(new java.awt.Color(51, 51, 51));
        dubbingTitle.setText("Doblaje:");

        decreaseDubbing.setBackground(new java.awt.Color(51, 51, 51));
        decreaseDubbing.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreaseDubbing.setForeground(new java.awt.Color(204, 204, 204));
        decreaseDubbing.setText("-");
        decreaseDubbing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseDubbingMouseClicked(evt);
            }
        });
        decreaseDubbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseDubbingActionPerformed(evt);
            }
        });

        increaseDubbing.setBackground(new java.awt.Color(51, 51, 51));
        increaseDubbing.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increaseDubbing.setForeground(new java.awt.Color(255, 255, 255));
        increaseDubbing.setText("+");
        increaseDubbing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseDubbingMouseClicked(evt);
            }
        });
        increaseDubbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseDubbingActionPerformed(evt);
            }
        });

        dubbingValues.setBackground(java.awt.Color.lightGray);
        dubbingValues.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingValues.setForeground(new java.awt.Color(51, 51, 51));
        dubbingValues.setText("0");
        dubbingValues.setBorder(null);
        dubbingValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dubbingValuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dubbingLayout = new javax.swing.GroupLayout(dubbing);
        dubbing.setLayout(dubbingLayout);
        dubbingLayout.setHorizontalGroup(
            dubbingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbingLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dubbingTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(increaseDubbing)
                .addGap(18, 18, 18)
                .addComponent(dubbingValues, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseDubbing)
                .addGap(15, 15, 15))
        );
        dubbingLayout.setVerticalGroup(
            dubbingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dubbingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dubbingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decreaseDubbing)
                        .addComponent(increaseDubbing)
                        .addComponent(dubbingValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dubbingTitle))
                .addContainerGap())
        );

        plotTwist.setBackground(java.awt.Color.lightGray);
        plotTwist.setForeground(new java.awt.Color(255, 255, 255));

        plotTwistTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistTitle.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistTitle.setText("PlotTwist:");

        increasePlotTwist.setBackground(new java.awt.Color(51, 51, 51));
        increasePlotTwist.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        increasePlotTwist.setForeground(new java.awt.Color(255, 255, 255));
        increasePlotTwist.setText("+");
        increasePlotTwist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increasePlotTwistMouseClicked(evt);
            }
        });
        increasePlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increasePlotTwistActionPerformed(evt);
            }
        });

        decreacePlotTwist.setBackground(new java.awt.Color(51, 51, 51));
        decreacePlotTwist.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        decreacePlotTwist.setForeground(new java.awt.Color(255, 255, 255));
        decreacePlotTwist.setText("-");
        decreacePlotTwist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreacePlotTwistMouseClicked(evt);
            }
        });
        decreacePlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreacePlotTwistActionPerformed(evt);
            }
        });

        plotTwistValues.setBackground(java.awt.Color.lightGray);
        plotTwistValues.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistValues.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistValues.setText("0");
        plotTwistValues.setBorder(null);
        plotTwistValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistValuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plotTwistLayout = new javax.swing.GroupLayout(plotTwist);
        plotTwist.setLayout(plotTwistLayout);
        plotTwistLayout.setHorizontalGroup(
            plotTwistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotTwistLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(plotTwistTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(increasePlotTwist)
                .addGap(18, 18, 18)
                .addComponent(plotTwistValues, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreacePlotTwist)
                .addGap(16, 16, 16))
        );
        plotTwistLayout.setVerticalGroup(
            plotTwistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotTwistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plotTwistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plotTwistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decreacePlotTwist)
                        .addComponent(increasePlotTwist)
                        .addComponent(plotTwistValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(plotTwistTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout workersConfigurationsLayout = new javax.swing.GroupLayout(workersConfigurations);
        workersConfigurations.setLayout(workersConfigurationsLayout);
        workersConfigurationsLayout.setHorizontalGroup(
            workersConfigurationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurationsLayout.createSequentialGroup()
                .addGroup(workersConfigurationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workersConfigurationsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(workersConfigurationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(animations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dubbing, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plotTwist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scenary, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scripts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(workersConfigurationsLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(workersConfigurationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driveTitle)
                            .addGroup(workersConfigurationsLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(driveTitle1)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        workersConfigurationsLayout.setVerticalGroup(
            workersConfigurationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersConfigurationsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(driveTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(driveTitle1)
                .addGap(26, 26, 26)
                .addComponent(scripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scenary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(animations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dubbing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plotTwist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(workersConfigurations, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 280, 400));

        drivePanel.setBackground(new java.awt.Color(243, 168, 71));

        driveTitle2.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle2.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle2.setText("ESTATUS DEL DRIVE");

        driveTitle3.setFont(new java.awt.Font("Montserrat", 1, 19)); // NOI18N
        driveTitle3.setForeground(new java.awt.Color(51, 51, 51));
        driveTitle3.setText("(Disponiblidad)");

        scripts1.setBackground(java.awt.Color.lightGray);
        scripts1.setForeground(new java.awt.Color(60, 63, 65));

        scriptTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptTitle1.setForeground(new java.awt.Color(51, 51, 51));
        scriptTitle1.setText("Guiones:");

        scriptsLimit1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptsLimit1.setForeground(new java.awt.Color(51, 51, 51));
        scriptsLimit1.setText("/25");

        scriptDrive.setBackground(java.awt.Color.lightGray);
        scriptDrive.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scriptDrive.setForeground(new java.awt.Color(51, 51, 51));
        scriptDrive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        scriptDrive.setText("0");
        scriptDrive.setBorder(null);
        scriptDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptDriveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scripts1Layout = new javax.swing.GroupLayout(scripts1);
        scripts1.setLayout(scripts1Layout);
        scripts1Layout.setHorizontalGroup(
            scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scriptTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(scriptDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scriptsLimit1)
                .addGap(16, 16, 16))
        );
        scripts1Layout.setVerticalGroup(
            scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scripts1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scripts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scriptTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scriptsLimit1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(scriptDrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scenary1.setBackground(java.awt.Color.lightGray);
        scenary1.setForeground(new java.awt.Color(60, 63, 65));

        scenaryTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryTitle1.setForeground(new java.awt.Color(51, 51, 51));
        scenaryTitle1.setText("Escenerarios:");

        scenaryLimit1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryLimit1.setForeground(new java.awt.Color(51, 51, 51));
        scenaryLimit1.setText("/20");

        scenaryDrive.setBackground(java.awt.Color.lightGray);
        scenaryDrive.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        scenaryDrive.setForeground(new java.awt.Color(51, 51, 51));
        scenaryDrive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        scenaryDrive.setText("0");
        scenaryDrive.setBorder(null);
        scenaryDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenaryDriveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scenary1Layout = new javax.swing.GroupLayout(scenary1);
        scenary1.setLayout(scenary1Layout);
        scenary1Layout.setHorizontalGroup(
            scenary1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(scenaryTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scenaryDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scenaryLimit1)
                .addGap(15, 15, 15))
        );
        scenary1Layout.setVerticalGroup(
            scenary1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scenary1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scenary1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scenaryTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scenaryLimit1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(scenaryDrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        animations1.setBackground(java.awt.Color.lightGray);
        animations1.setForeground(new java.awt.Color(60, 63, 65));

        animationsTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationsTitle1.setForeground(new java.awt.Color(51, 51, 51));
        animationsTitle1.setText("Animación:");

        animationsLimit1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationsLimit1.setForeground(new java.awt.Color(51, 51, 51));
        animationsLimit1.setText("/55");

        animationDrive.setBackground(java.awt.Color.lightGray);
        animationDrive.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        animationDrive.setForeground(new java.awt.Color(51, 51, 51));
        animationDrive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        animationDrive.setText("0");
        animationDrive.setBorder(null);
        animationDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationDriveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout animations1Layout = new javax.swing.GroupLayout(animations1);
        animations1.setLayout(animations1Layout);
        animations1Layout.setHorizontalGroup(
            animations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(animationsTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animationDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(animationsLimit1)
                .addGap(14, 14, 14))
        );
        animations1Layout.setVerticalGroup(
            animations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animations1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animationsTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(animationsLimit1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(animationDrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dubbing1.setBackground(java.awt.Color.lightGray);
        dubbing1.setForeground(new java.awt.Color(60, 63, 65));

        dubbingTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingTitle1.setForeground(new java.awt.Color(51, 51, 51));
        dubbingTitle1.setText("Doblaje:");

        dubbingLimit1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingLimit1.setForeground(new java.awt.Color(51, 51, 51));
        dubbingLimit1.setText("/35");

        dubbingDrive.setBackground(java.awt.Color.lightGray);
        dubbingDrive.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        dubbingDrive.setForeground(new java.awt.Color(51, 51, 51));
        dubbingDrive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dubbingDrive.setText("0");
        dubbingDrive.setBorder(null);
        dubbingDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dubbingDriveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dubbing1Layout = new javax.swing.GroupLayout(dubbing1);
        dubbing1.setLayout(dubbing1Layout);
        dubbing1Layout.setHorizontalGroup(
            dubbing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dubbingTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dubbingDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dubbingLimit1)
                .addGap(14, 14, 14))
        );
        dubbing1Layout.setVerticalGroup(
            dubbing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dubbing1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dubbing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dubbingTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dubbingLimit1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(dubbingDrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        plotTwist1.setBackground(java.awt.Color.lightGray);
        plotTwist1.setForeground(new java.awt.Color(60, 63, 65));

        plotTwistLimit1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistLimit1.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistLimit1.setText("/10");

        plotTwistTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistTitle1.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistTitle1.setText("PlotTwist:");

        plotTwistDrive.setBackground(java.awt.Color.lightGray);
        plotTwistDrive.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistDrive.setForeground(new java.awt.Color(51, 51, 51));
        plotTwistDrive.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        plotTwistDrive.setText("0");
        plotTwistDrive.setBorder(null);
        plotTwistDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistDriveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plotTwist1Layout = new javax.swing.GroupLayout(plotTwist1);
        plotTwist1.setLayout(plotTwist1Layout);
        plotTwist1Layout.setHorizontalGroup(
            plotTwist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotTwist1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(plotTwistTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plotTwistDrive, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plotTwistLimit1)
                .addGap(14, 14, 14))
        );
        plotTwist1Layout.setVerticalGroup(
            plotTwist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotTwist1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plotTwist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plotTwistLimit1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(plotTwistTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plotTwistDrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout drivePanelLayout = new javax.swing.GroupLayout(drivePanel);
        drivePanel.setLayout(drivePanelLayout);
        drivePanelLayout.setHorizontalGroup(
            drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drivePanelLayout.createSequentialGroup()
                .addGroup(drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drivePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driveTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(plotTwist1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dubbing1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(animations1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scenary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scripts1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(drivePanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(driveTitle3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        drivePanelLayout.setVerticalGroup(
            drivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drivePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(driveTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(driveTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(scripts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scenary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(animations1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dubbing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plotTwist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(drivePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 250, -1));

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Assets/playIcon.png"))); // NOI18N
        jButton12.setText("Pausar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 210, 40));

        jButton21.setBackground(new java.awt.Color(51, 51, 51));
        jButton21.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Assets/playIcon.png"))); // NOI18N
        jButton21.setText("Comenzar");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 210, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        driveTitle4.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle4.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle4.setText("Capítulos plotTwist:");

        driveTitle5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle5.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle5.setText("Capítulos normales:");

        driveTitle7.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        driveTitle7.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle7.setText("ENSAMBLAJE CAPÍTULOS");

        plotTwistChapters.setBackground(new java.awt.Color(51, 51, 51));
        plotTwistChapters.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        plotTwistChapters.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistChapters.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        plotTwistChapters.setText("0");
        plotTwistChapters.setBorder(null);
        plotTwistChapters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistChaptersActionPerformed(evt);
            }
        });

        standardChaptes.setBackground(new java.awt.Color(51, 51, 51));
        standardChaptes.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        standardChaptes.setForeground(new java.awt.Color(255, 255, 255));
        standardChaptes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        standardChaptes.setText("0");
        standardChaptes.setBorder(null);
        standardChaptes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardChaptesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(driveTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(driveTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(standardChaptes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plotTwistChapters, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(driveTitle7, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(driveTitle7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(driveTitle5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driveTitle4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(standardChaptes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plotTwistChapters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 300, 100));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setForeground(new java.awt.Color(51, 51, 51));

        driveTitle6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle6.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle6.setText("Días Restantes:");

        driveTitle8.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle8.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle8.setText("Días transcurridos:");

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(51, 51, 51));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.setEnabled(false);

        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(51, 51, 51));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.setEnabled(false);

        driveTitle19.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle19.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle19.setText("Días transcurridos:");

        driveTitle20.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle20.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle20.setText("Días restantes:");

        currentDays.setBackground(new java.awt.Color(51, 51, 51));
        currentDays.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        currentDays.setForeground(new java.awt.Color(255, 255, 255));
        currentDays.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        currentDays.setText("0");
        currentDays.setBorder(null);
        currentDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentDaysActionPerformed(evt);
            }
        });

        remainingDays.setBackground(new java.awt.Color(51, 51, 51));
        remainingDays.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        remainingDays.setForeground(new java.awt.Color(255, 255, 255));
        remainingDays.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        remainingDays.setText("0");
        remainingDays.setBorder(null);
        remainingDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingDaysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(driveTitle20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(driveTitle19, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentDays, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remainingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driveTitle8)
                            .addComponent(driveTitle6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle19)
                    .addComponent(currentDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle20)
                    .addComponent(remainingDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 300, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.setEnabled(false);

        driveTitle9.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle9.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle9.setText("Ganancia bruta:");

        driveTitle10.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle10.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle10.setText("Costos:");

        driveTitle11.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        driveTitle11.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle11.setText("COSTOS/ GANANCIAS");

        driveTitle17.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle17.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle17.setText("Ganancia neta:");

        cost.setBackground(new java.awt.Color(51, 51, 51));
        cost.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        cost.setForeground(new java.awt.Color(255, 255, 255));
        cost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cost.setText("0");
        cost.setBorder(null);
        cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costActionPerformed(evt);
            }
        });

        earning.setBackground(new java.awt.Color(51, 51, 51));
        earning.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        earning.setForeground(new java.awt.Color(255, 255, 255));
        earning.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        earning.setText("Dentro días");
        earning.setBorder(null);
        earning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                earningActionPerformed(evt);
            }
        });

        profit.setBackground(new java.awt.Color(51, 51, 51));
        profit.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        profit.setForeground(new java.awt.Color(255, 255, 255));
        profit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        profit.setText("Dentro días");
        profit.setBorder(null);
        profit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driveTitle10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driveTitle9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driveTitle17, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(earning, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(driveTitle11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driveTitle11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle10)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle9)
                    .addComponent(earning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle17)
                    .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 300, 120));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setForeground(new java.awt.Color(51, 51, 51));

        driveTitle14.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        driveTitle14.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        driveTitle14.setText("DIRECTOR");

        driveTitle18.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle18.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle18.setText("Estado:");

        directorStatus.setBackground(new java.awt.Color(51, 51, 51));
        directorStatus.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        directorStatus.setForeground(new java.awt.Color(255, 255, 255));
        directorStatus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        directorStatus.setText("0");
        directorStatus.setBorder(null);
        directorStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directorStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(driveTitle14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(300, 300, 300))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(driveTitle18)
                .addGap(47, 47, 47)
                .addComponent(directorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driveTitle14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driveTitle18))
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, 300, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setForeground(new java.awt.Color(51, 51, 51));
        jPanel8.setEnabled(false);

        driveTitle15.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        driveTitle15.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle15.setText("STATUS PROJECT MANAGER");

        driveTitle12.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle12.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle12.setText("Estado:");

        driveTitle13.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle13.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle13.setText("Faltas:");

        driveTitle16.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        driveTitle16.setForeground(new java.awt.Color(204, 204, 204));
        driveTitle16.setText("Penalización$:");

        projectManagerStatus.setBackground(new java.awt.Color(51, 51, 51));
        projectManagerStatus.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        projectManagerStatus.setForeground(new java.awt.Color(255, 255, 255));
        projectManagerStatus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        projectManagerStatus.setText("Por comenzar");
        projectManagerStatus.setBorder(null);
        projectManagerStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectManagerStatusActionPerformed(evt);
            }
        });

        strikeCounter.setBackground(new java.awt.Color(51, 51, 51));
        strikeCounter.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        strikeCounter.setForeground(new java.awt.Color(255, 255, 255));
        strikeCounter.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        strikeCounter.setText("0");
        strikeCounter.setBorder(null);
        strikeCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strikeCounterActionPerformed(evt);
            }
        });

        cashPenality.setBackground(new java.awt.Color(51, 51, 51));
        cashPenality.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        cashPenality.setForeground(new java.awt.Color(255, 255, 255));
        cashPenality.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cashPenality.setText("0");
        cashPenality.setBorder(null);
        cashPenality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashPenalityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driveTitle15)
                            .addComponent(driveTitle16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(driveTitle13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(driveTitle12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectManagerStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cashPenality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(strikeCounter, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(21, 21, 21))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driveTitle15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(driveTitle12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driveTitle13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(projectManagerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(strikeCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driveTitle16)
                    .addComponent(cashPenality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 300, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void plotTwistValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistValuesActionPerformed

    private void decreacePlotTwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreacePlotTwistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreacePlotTwistActionPerformed

    private void increasePlotTwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increasePlotTwistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increasePlotTwistActionPerformed

    private void dubbingValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dubbingValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dubbingValuesActionPerformed

    private void increaseDubbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseDubbingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseDubbingActionPerformed

    private void decreaseDubbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseDubbingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseDubbingActionPerformed

    private void decreaseAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseAnimationActionPerformed

    private void increaseAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseAnimationActionPerformed

    private void animationValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animationValuesActionPerformed

    private void decreaseScenaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScenaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScenaryActionPerformed

    private void increaseScenaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScenaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScenaryActionPerformed

    private void scenaryValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scenaryValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scenaryValueActionPerformed

    private void scriptsValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptsValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scriptsValuesActionPerformed

    private void increaseScriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScriptsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseScriptsActionPerformed

    private void decreaseScriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScriptsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseScriptsActionPerformed

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

    }//GEN-LAST:event_btn_nuevo_almacenMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel7MouseClicked

    private void icono4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_icono4MouseClicked

    private void btn_nueva_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nueva_rutaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_nueva_rutaMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:

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

    private void scriptDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptDriveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scriptDriveActionPerformed

    private void scenaryDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scenaryDriveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scenaryDriveActionPerformed

    private void animationDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationDriveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animationDriveActionPerformed

    private void dubbingDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dubbingDriveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dubbingDriveActionPerformed

    private void plotTwistDriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistDriveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistDriveActionPerformed

    private void currentDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentDaysActionPerformed

    private void remainingDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingDaysActionPerformed

    private void standardChaptesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardChaptesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_standardChaptesActionPerformed

    private void plotTwistChaptersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistChaptersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistChaptersActionPerformed

    private void strikeCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strikeCounterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strikeCounterActionPerformed

    private void projectManagerStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectManagerStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectManagerStatusActionPerformed

    private void directorStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directorStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directorStatusActionPerformed

    private void cashPenalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashPenalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashPenalityActionPerformed

    private void costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costActionPerformed

    private void earningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_earningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_earningActionPerformed

    private void profitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profitActionPerformed

    private void increaseScriptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScriptsMouseClicked
        // TODO add your handling code here:
        helper.addWorker(1, 0);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.scriptsValues.setText(increaseQuantity(this.scriptsValues.getText()));

    }//GEN-LAST:event_increaseScriptsMouseClicked

    private void increaseScenaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseScenaryMouseClicked
        // TODO add your handling code here:
        helper.addWorker(1, 1);
        this.scenaryValue.setText(increaseQuantity(this.scenaryValue.getText()));
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 

    }//GEN-LAST:event_increaseScenaryMouseClicked

    private void increaseAnimationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseAnimationMouseClicked
        // TODO add your handling code here:
        helper.addWorker(1, 2);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.animationValues.setText(increaseQuantity(this.animationValues.getText()));
    }//GEN-LAST:event_increaseAnimationMouseClicked

    private void increaseDubbingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseDubbingMouseClicked
        // TODO add your handling code here:
        helper.addWorker(1, 3);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.dubbingValues.setText(increaseQuantity(this.dubbingValues.getText()));

    }//GEN-LAST:event_increaseDubbingMouseClicked

    private void increasePlotTwistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increasePlotTwistMouseClicked
        // TODO add your handling code here:
        helper.addWorker(1, 4);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.plotTwistValues.setText(increaseQuantity(this.plotTwistValues.getText()));
    }//GEN-LAST:event_increasePlotTwistMouseClicked

    private void decreacePlotTwistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreacePlotTwistMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 4);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.plotTwistValues.setText(decreaseQuantity(this.plotTwistValues.getText()));

    }//GEN-LAST:event_decreacePlotTwistMouseClicked

    private void decreaseDubbingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseDubbingMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 3);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.dubbingValues.setText(decreaseQuantity(this.dubbingValues.getText()));

    }//GEN-LAST:event_decreaseDubbingMouseClicked

    private void decreaseAnimationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseAnimationMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 2);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.animationValues.setText(decreaseQuantity(this.animationValues.getText()));

    }//GEN-LAST:event_decreaseAnimationMouseClicked

    private void decreaseScenaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScenaryMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 1);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.scenaryValue.setText(decreaseQuantity(this.scenaryValue.getText()));

    }//GEN-LAST:event_decreaseScenaryMouseClicked

    private void decreaseScriptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseScriptsMouseClicked
        // TODO add your handling code here:
        helper.deleteWorker(1, 0);
        cartoonPlayMusic("/GUI/Assets/cartoonClick.wav"); 
        this.scriptsValues.setText(decreaseQuantity(this.scriptsValues.getText()));

    }//GEN-LAST:event_decreaseScriptsMouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton21MouseClicked

    private String increaseQuantity(String actualValue) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(actualValue);
            if (actualEmployees < maxEmployees) {
                intValue++;
                actualEmployees++;
            }
            return String.valueOf(intValue);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el valor a int: " + e.getMessage());
            return actualValue; // Retorna el valor actual en caso de error
        }
    }

    
    private String decreaseQuantity (String actualValue){
    int intValue = 0; 
        try {
            intValue = Integer.parseInt(actualValue); 
            if (intValue > 0){
                intValue --;
                actualEmployees --;
                return String.valueOf(intValue);
            }
            else{
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
            java.util.logging.Logger.getLogger(CartoonNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartoonNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartoonNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartoonNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartoonNetwork().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField animationDrive;
    private javax.swing.JTextField animationValues;
    private javax.swing.JPanel animations;
    private javax.swing.JPanel animations1;
    private javax.swing.JLabel animationsLimit1;
    private javax.swing.JLabel animationsTitle;
    private javax.swing.JLabel animationsTitle1;
    private javax.swing.JPanel btn_Inicio;
    private javax.swing.JPanel btn_cargar_guardar;
    private javax.swing.JPanel btn_nueva_ruta;
    private javax.swing.JPanel btn_nuevo_almacen;
    private javax.swing.JPanel btn_nuevo_pedido;
    private javax.swing.JPanel btn_reporte;
    private javax.swing.JTextField cashPenality;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField currentDays;
    private javax.swing.JButton decreacePlotTwist;
    private javax.swing.JButton decreaseAnimation;
    private javax.swing.JButton decreaseDubbing;
    private javax.swing.JButton decreaseScenary;
    private javax.swing.JButton decreaseScripts;
    private javax.swing.JTextField directorStatus;
    private javax.swing.JPanel drivePanel;
    private javax.swing.JLabel driveTitle;
    private javax.swing.JLabel driveTitle1;
    private javax.swing.JLabel driveTitle10;
    private javax.swing.JLabel driveTitle11;
    private javax.swing.JLabel driveTitle12;
    private javax.swing.JLabel driveTitle13;
    private javax.swing.JLabel driveTitle14;
    private javax.swing.JLabel driveTitle15;
    private javax.swing.JLabel driveTitle16;
    private javax.swing.JLabel driveTitle17;
    private javax.swing.JLabel driveTitle18;
    private javax.swing.JLabel driveTitle19;
    private javax.swing.JLabel driveTitle2;
    private javax.swing.JLabel driveTitle20;
    private javax.swing.JLabel driveTitle3;
    private javax.swing.JLabel driveTitle4;
    private javax.swing.JLabel driveTitle5;
    private javax.swing.JLabel driveTitle6;
    private javax.swing.JLabel driveTitle7;
    private javax.swing.JLabel driveTitle8;
    private javax.swing.JLabel driveTitle9;
    private javax.swing.JPanel dubbing;
    private javax.swing.JPanel dubbing1;
    private javax.swing.JTextField dubbingDrive;
    private javax.swing.JLabel dubbingLimit1;
    private javax.swing.JLabel dubbingTitle;
    private javax.swing.JLabel dubbingTitle1;
    private javax.swing.JTextField dubbingValues;
    private javax.swing.JTextField earning;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel icono3;
    private javax.swing.JLabel icono4;
    private javax.swing.JLabel icono5;
    private javax.swing.JLabel icono7;
    private javax.swing.JButton increaseAnimation;
    private javax.swing.JButton increaseDubbing;
    private javax.swing.JButton increasePlotTwist;
    private javax.swing.JButton increaseScenary;
    private javax.swing.JButton increaseScripts;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel plotTwist;
    private javax.swing.JPanel plotTwist1;
    private javax.swing.JTextField plotTwistChapters;
    private javax.swing.JTextField plotTwistDrive;
    private javax.swing.JLabel plotTwistLimit1;
    private javax.swing.JLabel plotTwistTitle;
    private javax.swing.JLabel plotTwistTitle1;
    private javax.swing.JTextField plotTwistValues;
    private javax.swing.JTextField profit;
    private javax.swing.JTextField projectManagerStatus;
    private javax.swing.JTextField remainingDays;
    private javax.swing.JPanel scenary;
    private javax.swing.JPanel scenary1;
    private javax.swing.JTextField scenaryDrive;
    private javax.swing.JLabel scenaryLimit1;
    private javax.swing.JLabel scenaryTitle;
    private javax.swing.JLabel scenaryTitle1;
    private javax.swing.JTextField scenaryValue;
    private javax.swing.JTextField scriptDrive;
    private javax.swing.JLabel scriptTitle1;
    private javax.swing.JPanel scripts;
    private javax.swing.JPanel scripts1;
    private javax.swing.JLabel scriptsLimit1;
    private javax.swing.JLabel scriptsTitle;
    private javax.swing.JTextField scriptsValues;
    private javax.swing.JTextField standardChaptes;
    private javax.swing.JTextField strikeCounter;
    private javax.swing.JPanel workersConfigurations;
    // End of variables declaration//GEN-END:variables
}
