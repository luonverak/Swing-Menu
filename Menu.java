package Databases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Menu extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet r;
    double total=0;
    
    DecimalFormat df=new DecimalFormat("#,#########0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    
    Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project_java_2_3","root","");
            System.out.println("Completed.....");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Error: "+e.getMessage());
            //JOptionPane.showMessageDialog(this, e);
        }
        return con;
    }
    
    public Menu() {
        initComponents();
    }

    public void Product(String item,int qty,float price){
        double total = Double.parseDouble(df.format(qty*price)); 
        try {
            ps=connection().prepareStatement("INSERT INTO `tbl_food`(`name`, `qty`, `price`, `total`) VALUES (?,?,?,?)");
            ps.setString(1, item);
            ps.setInt(2, qty);
            ps.setFloat(3, price);
            ps.setDouble(4, total);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Product1(String item,int qty,float price){
        double total = Double.parseDouble(df.format(qty*price)); 
        try {
            ps=connection().prepareStatement("INSERT INTO `tbl_drinks`(`name`, `qty`, `price`, `total`) VALUES (?,?,?,?)");
            ps.setString(1, item);
            ps.setInt(2, qty);
            ps.setFloat(3, price);
            ps.setDouble(4, total);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GetFood(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tbl_report.getModel();
        try {
            
            ps=connection().prepareStatement("select * from tbl_food");
            r=ps.executeQuery();
            while(r.next()){
                Object row[]={
                  r.getString(1),
                  r.getInt(2),
                  r.getFloat(3),
                  r.getDouble(4) 
                };
                ListProduct.list.add(new ListProduct(r.getString(1),r.getInt(2),r.getFloat(3),r.getDouble(4)));
                total +=r.getDouble(4);
                txt_subtotal.setText(String.valueOf(total));
                model.addRow(row);
                model2.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GetDrink(){
        DefaultTableModel model1 = (DefaultTableModel) table_drink.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tbl_report.getModel();
        try {       
            ps=connection().prepareStatement("select * from tbl_drinks");
            r=ps.executeQuery();
            while(r.next()){
                Object row[]={
                  r.getString(1),
                  r.getInt(2),
                  r.getFloat(3),
                  r.getDouble(4)
                };
                ListProduct.list.add(new ListProduct(r.getString(1),r.getInt(2),r.getFloat(3),r.getDouble(4)));
                total +=r.getDouble(4);
                txt_subtotal.setText(String.valueOf(total));
                model1.addRow(row);
                model2.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GetBooking(){
        DefaultTableModel mod=(DefaultTableModel) table_booking.getModel();
        try {
            ps=connection().prepareStatement("SELECT * FROM `tbl_booking`");
            r=ps.executeQuery();
            while(r.next()){
                Object row[]={
                    r.getInt(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getFloat(6),      
                };
                mod.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Collection data(){
        ArrayList<ListProduct> list=new ArrayList<>();
        for(ListProduct temp:ListProduct.list){
          
           String Name=temp.getName();
           int Qty=temp.getQty();
           float Price=temp.getPrice();
           double Amount=temp.getAmount();
           ListProduct pro=new ListProduct( Name, Qty, Price, Amount);
           list.add(pro);
        }
        return list;
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRoom = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFood = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnDrink = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        menu = new javax.swing.JPanel();
        home_screen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        food = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        js_1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        js_2 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel38 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSpinner13 = new javax.swing.JSpinner();
        jLabel58 = new javax.swing.JLabel();
        jSpinner14 = new javax.swing.JSpinner();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        drink = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        js_drink_1 = new javax.swing.JSpinner();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        js_drink_2 = new javax.swing.JSpinner();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jSpinner18 = new javax.swing.JSpinner();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jSpinner19 = new javax.swing.JSpinner();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jSpinner20 = new javax.swing.JSpinner();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jSpinner21 = new javax.swing.JSpinner();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jSpinner22 = new javax.swing.JSpinner();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jSpinner23 = new javax.swing.JSpinner();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jSpinner24 = new javax.swing.JSpinner();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jSpinner25 = new javax.swing.JSpinner();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jSpinner26 = new javax.swing.JSpinner();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jSpinner27 = new javax.swing.JSpinner();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jSpinner28 = new javax.swing.JSpinner();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jSpinner29 = new javax.swing.JSpinner();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jSpinner30 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_drink = new javax.swing.JTable();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton5 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();
        payment = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        cb_dis_1 = new javax.swing.JComboBox<>();
        jLabel127 = new javax.swing.JLabel();
        txt_dis_2 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        txt_payments = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        txt_cash_recieve = new javax.swing.JTextField();
        txt_cash_return = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_report = new javax.swing.JTable();
        btn_print = new com.k33ptoo.components.KButton();
        call_booking = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        txt_time = new com.toedter.calendar.JDateChooser();
        jLabel134 = new javax.swing.JLabel();
        cb_vip = new javax.swing.JCheckBox();
        cb_normal = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_booking = new javax.swing.JTable();
        jLabel135 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        kButton8 = new com.k33ptoo.components.KButton();
        kButton9 = new com.k33ptoo.components.KButton();
        kButton10 = new com.k33ptoo.components.KButton();
        txt_Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1677, 939));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Java2-3/src/Images/logo.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btnFood.setBackground(new java.awt.Color(0, 0, 0));
        btnFood.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnFood.setIcon(new javax.swing.ImageIcon("/Users/macbook/Downloads/bibimbap.png")); // NOI18N
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });

        btnPayment.setBackground(new java.awt.Color(0, 0, 0));
        btnPayment.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnPayment.setIcon(new javax.swing.ImageIcon("/Users/macbook/Downloads/payment-method.png")); // NOI18N
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnDrink.setBackground(new java.awt.Color(0, 0, 0));
        btnDrink.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnDrink.setIcon(new javax.swing.ImageIcon("/Users/macbook/Downloads/drink.png")); // NOI18N
        btnDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinkActionPerformed(evt);
            }
        });

        btnBooking.setBackground(new java.awt.Color(0, 0, 0));
        btnBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnBooking.setIcon(new javax.swing.ImageIcon("/Users/macbook/Downloads/phone-call.png")); // NOI18N
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDrink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBooking)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(new java.awt.CardLayout());

        home_screen.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Kannada MN", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome to My App");

        javax.swing.GroupLayout home_screenLayout = new javax.swing.GroupLayout(home_screen);
        home_screen.setLayout(home_screenLayout);
        home_screenLayout.setHorizontalGroup(
            home_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1579, Short.MAX_VALUE)
        );
        home_screenLayout.setVerticalGroup(
            home_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_screenLayout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(495, 495, 495))
        );

        menu.add(home_screen, "card2");

        food.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/2.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("Egg Fried Rice");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel8.setText("Amount :");

        js_1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setText("Price : 3.5 $");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel10.setText("Egg Fried Rice");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/14.png")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel12.setText("Price : 3.5 $");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel13.setText("Amount :");

        js_2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel14.setText("Egg Fried Rice");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/8.png")); // NOI18N

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel16.setText("Price : 3.5 $");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel17.setText("Amount :");

        jSpinner3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel18.setText("Amount :");

        jSpinner4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel19.setText("Price : 3.5 $");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/111.png")); // NOI18N

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel21.setText("Egg Fried Rice");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/7.png")); // NOI18N

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel23.setText("Egg Fried Rice");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel24.setText("Price : 3.5 $");

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel25.setText("Amount :");

        jSpinner5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/2.png")); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel27.setText("Egg Fried Rice");

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel28.setText("Amount :");

        jSpinner6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel29.setText("Price : 3.5 $");

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel30.setText("Egg Fried Rice");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/14.png")); // NOI18N

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel32.setText("Price : 3.5 $");

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel33.setText("Amount :");

        jSpinner7.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel34.setText("Egg Fried Rice");

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/8.png")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel36.setText("Price : 3.5 $");

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel37.setText("Amount :");

        jSpinner8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel38.setText("Amount :");

        jSpinner9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel39.setText("Price : 3.5 $");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/111.png")); // NOI18N

        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel41.setText("Egg Fried Rice");

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/7.png")); // NOI18N

        jLabel43.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel43.setText("Egg Fried Rice");

        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel44.setText("Price : 3.5 $");

        jLabel45.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel45.setText("Amount :");

        jSpinner10.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/2.png")); // NOI18N

        jLabel47.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel47.setText("Egg Fried Rice");

        jLabel48.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel48.setText("Amount :");

        jSpinner11.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel49.setText("Price : 3.5 $");

        jLabel50.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel50.setText("Egg Fried Rice");

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/14.png")); // NOI18N

        jLabel52.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel52.setText("Price : 3.5 $");

        jLabel53.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel53.setText("Amount :");

        jSpinner12.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel54.setText("Egg Fried Rice");

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/8.png")); // NOI18N

        jLabel56.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel56.setText("Price : 3.5 $");

        jLabel57.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel57.setText("Amount :");

        jSpinner13.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel58.setText("Amount :");

        jSpinner14.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel59.setText("Price : 3.5 $");

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/111.png")); // NOI18N

        jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel61.setText("Egg Fried Rice");

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/7.png")); // NOI18N

        jLabel63.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel63.setText("Egg Fried Rice");

        jLabel64.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel64.setText("Price : 3.5 $");

        jLabel65.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel65.setText("Amount :");

        jSpinner15.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Qty", "Price", "Amount"
            }
        ));
        table.setRowHeight(25);
        jScrollPane1.setViewportView(table);

        kButton1.setText("Reset");
        kButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setText("Buy");
        kButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton2.setkEndColor(new java.awt.Color(51, 102, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(51, 102, 255));
        kButton2.setkStartColor(new java.awt.Color(0, 0, 204));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("Remove");
        kButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton3.setkEndColor(new java.awt.Color(255, 102, 102));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        kButton3.setkStartColor(new java.awt.Color(255, 51, 0));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout foodLayout = new javax.swing.GroupLayout(food);
        food.setLayout(foodLayout);
        foodLayout.setHorizontalGroup(
            foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodLayout.createSequentialGroup()
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel39)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel44)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(js_1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(js_2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(foodLayout.createSequentialGroup()
                                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(foodLayout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(115, 115, 115)
                                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(foodLayout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(115, 115, 115)
                                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(foodLayout.createSequentialGroup()
                                        .addComponent(jLabel57)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(foodLayout.createSequentialGroup()
                                    .addComponent(jLabel58)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel59)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(foodLayout.createSequentialGroup()
                                    .addComponent(jLabel65)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel64)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodLayout.createSequentialGroup()
                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addGap(100, 100, 100))
        );
        foodLayout.setVerticalGroup(
            foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(js_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(js_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(foodLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(foodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))))
        );

        menu.add(food, "card3");

        drink.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/crb1.png")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("Caraboa");

        jLabel67.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel67.setText("Price : 3.5 $");

        jLabel68.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel68.setText("Amount :");

        js_drink_1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel69.setText("Mlik Tea");

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/03.png")); // NOI18N

        jLabel71.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel71.setText("Price : 3.5 $");

        jLabel72.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel72.setText("Amount :");

        js_drink_2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel73.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel73.setText("Coffee");

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/02.png")); // NOI18N

        jLabel75.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel75.setText("Price : 3.5 $");

        jLabel76.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel76.setText("Amount :");

        jSpinner18.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/09.png")); // NOI18N

        jLabel78.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel78.setText("New Modern");

        jLabel79.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel79.setText("Price : 3.5 $");

        jLabel80.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel80.setText("Amount :");

        jSpinner19.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel81.setText("Water");

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/water.png")); // NOI18N

        jLabel83.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel83.setText("Price : 3.5 $");

        jLabel84.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel84.setText("Amount :");

        jSpinner20.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/crb1.png")); // NOI18N

        jLabel86.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel86.setText("Caraboa");

        jLabel87.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel87.setText("Price : 3.5 $");

        jLabel88.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel88.setText("Amount :");

        jSpinner21.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel89.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel89.setText("Mlik Tea");

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/03.png")); // NOI18N

        jLabel91.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel91.setText("Price : 3.5 $");

        jLabel92.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel92.setText("Amount :");

        jSpinner22.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel93.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel93.setText("Coffee");

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/02.png")); // NOI18N

        jLabel95.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel95.setText("Price : 3.5 $");

        jLabel96.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel96.setText("Amount :");

        jSpinner23.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/09.png")); // NOI18N

        jLabel98.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel98.setText("New Modern");

        jLabel99.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel99.setText("Price : 3.5 $");

        jLabel100.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel100.setText("Amount :");

        jSpinner24.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel101.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel101.setText("Water");

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/caco.png")); // NOI18N

        jLabel103.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel103.setText("Price : 3.5 $");

        jLabel104.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel104.setText("Amount :");

        jSpinner25.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/crb1.png")); // NOI18N

        jLabel106.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel106.setText("Caraboa");

        jLabel107.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel107.setText("Price : 3.5 $");

        jLabel108.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel108.setText("Amount :");

        jSpinner26.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel109.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel109.setText("Mlik Tea");

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/03.png")); // NOI18N

        jLabel111.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel111.setText("Price : 3.5 $");

        jLabel112.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel112.setText("Amount :");

        jSpinner27.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel113.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel113.setText("Coffee");

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/02.png")); // NOI18N

        jLabel115.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel115.setText("Price : 3.5 $");

        jLabel116.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel116.setText("Amount :");

        jSpinner28.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/09.png")); // NOI18N

        jLabel118.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel118.setText("New Modern");

        jLabel119.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel119.setText("Price : 3.5 $");

        jLabel120.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel120.setText("Amount :");

        jSpinner29.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel121.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel121.setText("Water");

        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Report/src/images/ize.png")); // NOI18N

        jLabel123.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel123.setText("Price : 3.5 $");

        jLabel124.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel124.setText("Amount :");

        jSpinner30.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        table_drink.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table_drink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Qty", "Price", "Amount"
            }
        ));
        table_drink.setRowHeight(25);
        jScrollPane2.setViewportView(table_drink);

        kButton4.setText("Buy");
        kButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton4.setkEndColor(new java.awt.Color(51, 102, 255));
        kButton4.setkHoverEndColor(new java.awt.Color(51, 102, 255));
        kButton4.setkStartColor(new java.awt.Color(0, 0, 204));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setText("Remove");
        kButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton5.setkEndColor(new java.awt.Color(255, 102, 102));
        kButton5.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        kButton5.setkStartColor(new java.awt.Color(255, 51, 0));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        kButton6.setText("Reset");
        kButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drinkLayout = new javax.swing.GroupLayout(drink);
        drink.setLayout(drinkLayout);
        drinkLayout.setHorizontalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner26, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel107)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner27, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel111)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel115)
                            .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner29, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel119)
                            .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner30, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel123)
                            .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner21, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel87)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner22, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel91)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner23, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel95)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner24, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel99)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel104)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner25, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel103)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(js_drink_1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel67)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(js_drink_2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel71)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner18, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel75)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel79)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(drinkLayout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner20, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel83)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(114, 114, 114))
        );
        drinkLayout.setVerticalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jSpinner20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(jSpinner19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jSpinner18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(js_drink_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(js_drink_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(jSpinner24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jSpinner23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(jSpinner22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(jSpinner21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(jSpinner25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(jSpinner30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(jSpinner29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(jSpinner28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(jSpinner27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(drinkLayout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(jSpinner26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinkLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)))
                .addGap(7, 7, 7))
        );

        menu.add(drink, "card4");

        payment.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Java2-3/src/Images/online-payment-security-concept-3d-phone-bill.png")); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel125.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel125.setText("Discount");

        txt_subtotal.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_subtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_subtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));

        jLabel126.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel126.setText("SubTotal");

        cb_dis_1.setEditable(true);
        cb_dis_1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_dis_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 %", "10 %", "20 %", "30 %", "40 %", "50 %" }));
        cb_dis_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_dis_1ActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel127.setText("Discount $");

        txt_dis_2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_dis_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dis_2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));

        jLabel128.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel128.setText("Payment");

        txt_payments.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_payments.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_payments.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));

        jLabel129.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel129.setText("Cash Return");

        jLabel130.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel130.setText("Cash Recieve");

        txt_cash_recieve.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_cash_recieve.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cash_recieve.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));
        txt_cash_recieve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cash_recieveKeyReleased(evt);
            }
        });

        txt_cash_return.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_cash_return.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cash_return.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));
        txt_cash_return.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cash_returnKeyReleased(evt);
            }
        });

        tbl_report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Qty", "Price", "Amount"
            }
        ));
        jScrollPane3.setViewportView(tbl_report);

        btn_print.setText("Payment");
        btn_print.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        btn_print.setkEndColor(new java.awt.Color(51, 153, 255));
        btn_print.setkHoverEndColor(new java.awt.Color(102, 153, 255));
        btn_print.setkStartColor(new java.awt.Color(51, 153, 255));
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paymentLayout = new javax.swing.GroupLayout(payment);
        payment.setLayout(paymentLayout);
        paymentLayout.setHorizontalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paymentLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paymentLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(paymentLayout.createSequentialGroup()
                                        .addComponent(jLabel129)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_cash_return, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paymentLayout.createSequentialGroup()
                                        .addComponent(jLabel130)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cash_recieve, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentLayout.createSequentialGroup()
                                        .addComponent(jLabel127)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                        .addComponent(txt_dis_2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paymentLayout.createSequentialGroup()
                                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel125)
                                                .addComponent(jLabel128))
                                            .addGroup(paymentLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel126)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_payments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_subtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_dis_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(paymentLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        paymentLayout.setVerticalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentLayout.createSequentialGroup()
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paymentLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_dis_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dis_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_payments, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cash_recieve, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cash_return, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paymentLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGap(163, 163, 163))
        );

        menu.add(payment, "card5");

        call_booking.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/macbook/NetBeansProjects/Java2-3/src/Images/2346619.png")); // NOI18N

        jLabel131.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel131.setText("Name");

        txt_name.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel132.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel132.setText("Room");

        txt_phone.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel133.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel133.setText("Phone");

        jLabel134.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel134.setText("Date");

        bgRoom.add(cb_vip);
        cb_vip.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        cb_vip.setText("VIP");

        bgRoom.add(cb_normal);
        cb_normal.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        cb_normal.setText("Normal");

        table_booking.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table_booking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Phone", "Date", "Room", "Price"
            }
        ));
        table_booking.setRowHeight(30);
        table_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookingMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_booking);
        if (table_booking.getColumnModel().getColumnCount() > 0) {
            table_booking.getColumnModel().getColumn(0).setMinWidth(0);
            table_booking.getColumnModel().getColumn(0).setPreferredWidth(0);
            table_booking.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel135.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        jLabel135.setText("Price");

        txt_price.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        kButton8.setText("Remove");
        kButton8.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        kButton8.setkEndColor(new java.awt.Color(255, 102, 102));
        kButton8.setkHoverEndColor(new java.awt.Color(255, 102, 102));
        kButton8.setkStartColor(new java.awt.Color(255, 51, 51));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        kButton9.setText("Save");
        kButton9.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        kButton9.setkEndColor(new java.awt.Color(51, 102, 255));
        kButton9.setkHoverEndColor(new java.awt.Color(0, 102, 255));
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });

        kButton10.setText("Update");
        kButton10.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        kButton10.setkEndColor(new java.awt.Color(255, 153, 51));
        kButton10.setkHoverEndColor(new java.awt.Color(255, 102, 0));
        kButton10.setkStartColor(new java.awt.Color(255, 153, 51));
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        txt_Id.setFont(new java.awt.Font("Helvetica Neue", 0, 3)); // NOI18N
        txt_Id.setForeground(new java.awt.Color(255, 255, 255));
        txt_Id.setBorder(null);

        javax.swing.GroupLayout call_bookingLayout = new javax.swing.GroupLayout(call_booking);
        call_booking.setLayout(call_bookingLayout);
        call_bookingLayout.setHorizontalGroup(
            call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(call_bookingLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(call_bookingLayout.createSequentialGroup()
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(call_bookingLayout.createSequentialGroup()
                                .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(call_bookingLayout.createSequentialGroup()
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(call_bookingLayout.createSequentialGroup()
                                .addComponent(jLabel131)
                                .addGap(33, 33, 33)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(call_bookingLayout.createSequentialGroup()
                                .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel133)
                                    .addComponent(jLabel132)
                                    .addComponent(jLabel134))
                                .addGap(33, 33, 33)
                                .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_phone, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                    .addComponent(txt_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(call_bookingLayout.createSequentialGroup()
                                        .addComponent(cb_normal)
                                        .addGap(43, 43, 43)
                                        .addComponent(cb_vip))))
                            .addGroup(call_bookingLayout.createSequentialGroup()
                                .addComponent(jLabel135)
                                .addGap(33, 33, 33)
                                .addComponent(txt_price)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        call_bookingLayout.setVerticalGroup(
            call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, call_bookingLayout.createSequentialGroup()
                .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(call_bookingLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(call_bookingLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_time, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, call_bookingLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_vip)
                            .addComponent(cb_normal))
                        .addGap(40, 40, 40)
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(call_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(77, 77, 77))
                    .addGroup(call_bookingLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );

        menu.add(call_booking, "card6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        setSize(new java.awt.Dimension(1677, 967));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        menu.removeAll();
        menu.add(food);
        menu.repaint();
        menu.revalidate();
    }//GEN-LAST:event_btnFoodActionPerformed

    private void btnDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrinkActionPerformed
        menu.removeAll();
        menu.add(drink);
        menu.repaint();
        menu.revalidate();
    }//GEN-LAST:event_btnDrinkActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        menu.removeAll();
        menu.add(home_screen);
        menu.repaint();
        menu.revalidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        menu.removeAll();
        menu.add(payment);
        menu.repaint();
        menu.revalidate();
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        menu.removeAll();
        menu.add(call_booking);
        menu.repaint();
        menu.revalidate();
    }//GEN-LAST:event_btnBookingActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
          
        try {
            int qty1=(int) js_1.getValue();
            if(qty1>0){
                Product("Egg Fried Rice", qty1, 3.5f);          
            }
            GetFood();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Can not");
        }
             
    }//GEN-LAST:event_kButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        GetFood();
        GetDrink();
        GetBooking();
    }//GEN-LAST:event_formWindowOpened

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        String name = table.getValueAt(row, 0).toString();
        try {
            ps=connection().prepareStatement("delete from `tbl_food` where `name` = ?");
            ps.setString(1, name);
            ps.execute();
            model.setRowCount(0);
            GetFood();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            ps=connection().prepareStatement("delete from tbl_food");
            ps.execute();
            model.setRowCount(0);
            GetFood();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        try {
            int d_qty1=(int) js_drink_1.getValue();
            if(d_qty1>0){
                Product1("Carabao", d_qty1, 0.6f);
            }
            
            GetDrink();
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table_drink.getModel();
        int row = table_drink.getSelectedRow();
        String name = table_drink.getValueAt(row, 0).toString();
        try {
            ps=connection().prepareStatement("delete from `tbl_food` where `name` = ?");
            ps.setString(1, name);
            ps.execute();
            model.setRowCount(0);
            GetFood();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table_drink.getModel();
        try {
            ps=connection().prepareStatement("delete from tbl_drinks");
            ps.execute();
            model.setRowCount(0);
            GetDrink();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        String name = txt_name.getText();
        String phone= txt_phone.getText();
        String date = sdf.format(txt_time.getDate());
        String room = (cb_normal.isSelected()==true) ? "Normal" : "VIP";
        float  price= Float.parseFloat(txt_price.getText());
        try {
            ps=connection().prepareStatement("INSERT INTO `tbl_booking`(`name`, `phone`, `date_time`, `room`, `price`) VALUES (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, date);
            ps.setString(4, room);
            ps.setFloat(5, price);
            ps.executeUpdate();
            DefaultTableModel mod=(DefaultTableModel)table_booking.getModel();
            mod.setRowCount(0);
            GetBooking();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton9ActionPerformed

    private void table_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookingMouseClicked
        DefaultTableModel model=(DefaultTableModel) table_booking.getModel();
        int row = table_booking.getSelectedRow();
        txt_Id.setText(model.getValueAt(row,0).toString());
        txt_name.setText(model.getValueAt(row, 1).toString());
        txt_phone.setText(model.getValueAt(row, 2).toString());
        try {
            java.util.Date obj = sdf.parse(model.getValueAt(row, 3).toString());
            txt_time.setDate(obj);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        String room=model.getValueAt(row, 4).toString();
        if(room.equalsIgnoreCase("Normal")){
            cb_normal.setSelected(true);
        }else{
            cb_vip.setSelected(true);
        }
        txt_price.setText(model.getValueAt(row, 5).toString());
    }//GEN-LAST:event_table_bookingMouseClicked

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        int id=Integer.parseInt(txt_Id.getText());
        String name = txt_name.getText();
        String phone= txt_phone.getText();
        String date = sdf.format(txt_time.getDate());
        String room = (cb_normal.isSelected()==true) ? "Normal" : "VIP";
        float  price= Float.parseFloat(txt_price.getText());
        try {
            ps=connection().prepareStatement("update tbl_booking set name=?,phone=?,date_time=?,room=?,price=? where id=?");
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, date);
            ps.setString(4, room);
            ps.setFloat(5, price);
            ps.setInt(6, id);
            ps.executeUpdate();
            DefaultTableModel mod=(DefaultTableModel)table_booking.getModel();
            mod.setRowCount(0);
            GetBooking();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        DefaultTableModel mod=(DefaultTableModel) table_booking.getModel();
        int id=Integer.parseInt(txt_Id.getText());
        try {
            ps=connection().prepareStatement("delete from tbl_booking where id=?");
            ps.setInt(1, id);
            ps.execute();
            mod.setRowCount(0);
            GetBooking();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton8ActionPerformed

    private void cb_dis_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_dis_1ActionPerformed
        DecimalFormat df=new DecimalFormat("#,#####0.00");
        int op=cb_dis_1.getSelectedIndex();
        int discout = 0;
        
        switch(op)
        {
            case 0:
            {
                 discout=0;
            }break;
            case 1:
            {
                discout=10;
            }break;
            case 2:
            {
                discout=20;
            }break;
            case 3:
            {
                discout=30;
            }break;
            case 4:
            {
                discout=40;
            }break;
            case 5:
            {
                discout=50;
            }break;
            
        }
        double pay=total - (total*discout)/100;
        txt_payments.setText(String.valueOf(df.format(pay)));
        double dis_money=(total*discout)/100;
        txt_dis_2.setText(String.valueOf(df.format(dis_money)));
    }//GEN-LAST:event_cb_dis_1ActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try {
            
            float totals=Float.parseFloat(txt_subtotal.getText());
            String sdis=cb_dis_1.getSelectedItem().toString();
            sdis=sdis.substring(0,sdis.length()-2);
            float dis=Float.parseFloat(sdis);
            float ds=Float.parseFloat(txt_dis_2.getText());
            float pay=Float.parseFloat(txt_payments.getText());
            float c_r=Float.parseFloat(txt_cash_recieve.getText());
            float c_re=Float.parseFloat(txt_cash_return.getText());
            
            JasperReport jp = JasperCompileManager.compileReport("src/Report_File/report_pro.jrxml");
            HashMap pr = new HashMap();
            
            pr.put("sub_total",totals);
            pr.put("dis_1",dis);
            pr.put("dis_2",ds);
            pr.put("payment",pay);
            pr.put("cash_recieve",c_r);
            pr.put("cash_return",c_re);
            
            
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data());
            JasperPrint price = JasperFillManager.fillReport(jp, pr,jcd);
            JasperViewer.viewReport(price,false);
           
            //JasperPrintManager.printReport(price, true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_cash_recieveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cash_recieveKeyReleased
        
        double pay=0;
        double cash_recieve = Double.parseDouble(txt_cash_recieve.getText());
        double payment = Double.parseDouble(txt_payments.getText());
        pay = cash_recieve - payment;
        txt_cash_return.setText(String.valueOf(df.format(pay)));
       
    }//GEN-LAST:event_txt_cash_recieveKeyReleased

    private void txt_cash_returnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cash_returnKeyReleased
        
    }//GEN-LAST:event_txt_cash_returnKeyReleased

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgRoom;
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnDrink;
    private javax.swing.JButton btnFood;
    private javax.swing.JButton btnPayment;
    private com.k33ptoo.components.KButton btn_print;
    private javax.swing.JPanel call_booking;
    private javax.swing.JComboBox<String> cb_dis_1;
    private javax.swing.JCheckBox cb_normal;
    private javax.swing.JCheckBox cb_vip;
    private javax.swing.JPanel drink;
    private javax.swing.JPanel food;
    private javax.swing.JPanel home_screen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner18;
    private javax.swing.JSpinner jSpinner19;
    private javax.swing.JSpinner jSpinner20;
    private javax.swing.JSpinner jSpinner21;
    private javax.swing.JSpinner jSpinner22;
    private javax.swing.JSpinner jSpinner23;
    private javax.swing.JSpinner jSpinner24;
    private javax.swing.JSpinner jSpinner25;
    private javax.swing.JSpinner jSpinner26;
    private javax.swing.JSpinner jSpinner27;
    private javax.swing.JSpinner jSpinner28;
    private javax.swing.JSpinner jSpinner29;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner30;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JSpinner js_1;
    private javax.swing.JSpinner js_2;
    private javax.swing.JSpinner js_drink_1;
    private javax.swing.JSpinner js_drink_2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton10;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton8;
    private com.k33ptoo.components.KButton kButton9;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel payment;
    private javax.swing.JTable table;
    private javax.swing.JTable table_booking;
    private javax.swing.JTable table_drink;
    private javax.swing.JTable tbl_report;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_cash_recieve;
    private javax.swing.JTextField txt_cash_return;
    private javax.swing.JTextField txt_dis_2;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_payments;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_subtotal;
    private com.toedter.calendar.JDateChooser txt_time;
    // End of variables declaration//GEN-END:variables
}