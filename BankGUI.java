// Imports
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * A class which represents a GUI Application for creating, storing and managing Credit and Debit Cards.
 *
 * @author (Manish Koirala)
 * @version (21st April 2023)
 */
public class BankGUI implements ActionListener
{
    /* Attributes of BankGUI class */
    private ArrayList<BankCard> cardList = new ArrayList<BankCard>(); // An ArrayList that stores CreditCard and BankCard objects
    private JFrame frame1; // A single frame which contains three panels
    private JPanel panel1, panel2, panel3, // Three main panels
        panel2_sub1, panel2_sub2, panel2_sub3, // Three Subpanels for panel2
        panel3_sub1, panel3_sub2, panel3_sub3; // Three Subpanels for panel3
    private Color BG_COLOR; // background color
    private Font BIG_FONT, SMALL_FONT; // fonts
    
    // Components of panel1
    private JButton db_card_btn, cr_card_btn;
    
    // Components of panel2 (DebitCard Part)
    private JLabel db_card_heading, db_withdraw_heading, db_miscellaneous_heading; // Headings
    private JLabel card_id_db_lbl1, card_id_db_lbl2, card_id_db_lbl3, balance_amount_db_lbl, bank_account_db_lbl, // text-labels
        issuer_bank_db_lbl, client_name_db_lbl, pin_number_db_lbl1, pin_number_db_lbl2, withdraw_amount_db_lbl, 
        date_of_withdraw_lbl;
    private JTextField card_id_db_tf1, card_id_db_tf2, card_id_db_tf3, balance_amount_db_tf, bank_account_db_tf, // text-input-fields
        issuer_bank_db_tf, client_name_db_tf, pin_number_db_tf1, pin_number_db_tf2, withdraw_amount_db_tf;
    private JComboBox date_of_withdraw_day, date_of_withdraw_month, date_of_withdraw_year; // combo-boxes
    private JButton add_db_card_btn, withdraw_button, db_display_btn, db_clear_btn, db_go_back_btn; // buttons
        
    // Components of panel3 (CreditCard Part)
    private JLabel cr_card_heading, cr_set_creditLimit_heading, cr_miscellaneous_heading; // Headings
    private JLabel card_id_cr_lbl1, card_id_cr_lbl2, card_id_cr_lbl3, balance_amount_cr_lbl, bank_account_cr_lbl, // text-labels
        issuer_bank_cr_lbl, client_name_cr_lbl, cvc_number_cr_lbl, credit_limit_cr_lbl, interest_rate_cr_lbl, 
        grace_period_cr_lbl, expire_date_lbl; 
    private JTextField card_id_cr_tf1, card_id_cr_tf2, card_id_cr_tf3, balance_amount_cr_tf, bank_account_cr_tf, // text-input-fields
        issuer_bank_cr_tf, client_name_cr_tf, cvc_number_cr_tf, credit_limit_cr_tf, interest_rate_cr_tf, 
        grace_period_cr_tf; 
    private JComboBox expire_date_month, expire_date_year, expire_date_day; // combo-boxes
    private JButton add_cr_card_btn, set_credit_limit_btn, cancel_credit_btn ,cr_clear_btn, cr_display_btn, cr_go_back_btn ; // buttons
    
    // A private instance method to initialize and add the components of panel1.
    private void create_panel1() {
        /* Initialize panel1 */
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 800, 625);
        panel1.setLayout(null);
        
        /* Create components for panel1 */
        db_card_btn = new JButton("Debit Card");
        db_card_btn.setBackground(BG_COLOR);
        db_card_btn.setFont(BIG_FONT);
        db_card_btn.setBounds(230, 180, 300, 100);
        db_card_btn.addActionListener(this);
        cr_card_btn = new JButton("Credit Card");
        cr_card_btn.setBackground(BG_COLOR);
        cr_card_btn.setBounds(230, 320, 300, 100);
        cr_card_btn.setFont(BIG_FONT);
        cr_card_btn.addActionListener(this);
        
        /* Add the components to panel1 */
        panel1.add(db_card_btn);
        panel1.add(cr_card_btn);
    }
    
    // A private instance method to initialize and add the GUI components to panel2
    private void create_panel2() {
        // Initialize panel2 (Debit Card Panel)
        panel2 = new JPanel();
        panel2.setBounds(0, 0, 800, 625);
        panel2.setLayout(null);
        
        // Initialize subpanels of panel2
        panel2_sub1 = new JPanel();
        panel2_sub1.setLayout(null);
        panel2_sub1.setBounds(15, 15, 755, 275);
        panel2_sub1.setBackground(BG_COLOR);
        panel2_sub2 = new JPanel();
        panel2_sub2.setLayout(null);
        panel2_sub2.setBounds(15, 305, 400, 270);
        panel2_sub2.setBackground(BG_COLOR);
        panel2_sub3 = new JPanel();
        panel2_sub3.setLayout(null);
        panel2_sub3.setBounds(425, 305, 345, 270);
        panel2_sub3.setBackground(BG_COLOR);
        
        /* Subpanel 1*/
        // Labels
        db_card_heading = new JLabel("Debit Card");
        db_card_heading.setFont(BIG_FONT);
        db_card_heading.setBounds(300, 30, 300, 50);
        card_id_db_lbl1 = new JLabel("Card ID:");
        card_id_db_lbl1.setFont(SMALL_FONT);
        card_id_db_lbl1.setBounds(25, 100, 160, 25);
        balance_amount_db_lbl = new JLabel("Balance Amount:");
        balance_amount_db_lbl.setFont(SMALL_FONT);
        balance_amount_db_lbl.setBounds(25, 135, 160, 25);
        bank_account_db_lbl = new JLabel("Bank Account:");
        bank_account_db_lbl.setFont(SMALL_FONT);
        bank_account_db_lbl.setBounds(25, 170, 160, 25);
        issuer_bank_db_lbl = new JLabel("Issuer Bank:");
        issuer_bank_db_lbl.setFont(SMALL_FONT);
        issuer_bank_db_lbl.setBounds(400, 100, 160, 25);
        client_name_db_lbl = new JLabel("Client Name:");
        client_name_db_lbl.setFont(SMALL_FONT);
        client_name_db_lbl.setBounds(400, 135, 160, 25);
        pin_number_db_lbl1 = new JLabel("Pin Number:");
        pin_number_db_lbl1.setFont(SMALL_FONT);
        pin_number_db_lbl1.setBounds(400, 170, 160, 25);
        // TextFields
        card_id_db_tf1 = new JTextField();
        card_id_db_tf1.setFont(SMALL_FONT);
        card_id_db_tf1.setBounds(180, 100, 160, 25);
        balance_amount_db_tf = new JTextField();
        balance_amount_db_tf.setFont(SMALL_FONT);
        balance_amount_db_tf.setBounds(180, 135, 160, 25);
        bank_account_db_tf = new JTextField();
        bank_account_db_tf.setFont(SMALL_FONT);
        bank_account_db_tf.setBounds(180, 170, 160, 25);
        issuer_bank_db_tf = new JTextField();
        issuer_bank_db_tf.setFont(SMALL_FONT);
        issuer_bank_db_tf.setBounds(560, 100, 160, 25);
        client_name_db_tf = new JTextField();
        client_name_db_tf.setFont(SMALL_FONT);
        client_name_db_tf.setBounds(560, 135, 160, 25);
        pin_number_db_tf1 = new JTextField();
        pin_number_db_tf1.setFont(SMALL_FONT);
        pin_number_db_tf1.setBounds(560, 170, 160, 25);
        // Buttons
        add_db_card_btn = new JButton("Add Debit Card");
        add_db_card_btn.setFont(SMALL_FONT);
        add_db_card_btn.setBounds(400, 220, 180, 35);
        add_db_card_btn.addActionListener(this);
        db_go_back_btn = new JButton("Go Back");
        db_go_back_btn.setFont(SMALL_FONT);
        db_go_back_btn.setBounds(600, 220, 120, 35);
        db_go_back_btn.addActionListener(this);
        
        /* Subpanel2*/
        // Headings
        db_withdraw_heading = new JLabel("Withdraw Cash");
        db_withdraw_heading.setFont(BIG_FONT);
        db_withdraw_heading.setBounds(75, 15, 260, 40);
        // Labels and Text-fields
        card_id_db_lbl2 = new JLabel("Card Id:");
        card_id_db_lbl2.setFont(SMALL_FONT);
        card_id_db_lbl2.setBounds(25, 70, 160, 30);
        card_id_db_tf2 = new JTextField();
        card_id_db_tf2.setFont(SMALL_FONT);
        card_id_db_tf2.setBounds(200, 70, 160, 30);
        withdraw_amount_db_lbl = new JLabel("Withdraw Amount:");
        withdraw_amount_db_lbl.setFont(SMALL_FONT);
        withdraw_amount_db_lbl.setBounds(25, 110, 160, 30);
        withdraw_amount_db_tf = new JTextField();
        withdraw_amount_db_tf.setFont(SMALL_FONT);
        withdraw_amount_db_tf.setBounds(200, 110, 160, 30);
        date_of_withdraw_lbl = new JLabel("Date Of Withdraw:");
        date_of_withdraw_lbl.setFont(SMALL_FONT);
        date_of_withdraw_lbl.setBounds(25, 150, 160, 30);
        //Comboboxes
        date_of_withdraw_year = new JComboBox();
        for (int i=1960; i<=2023; i++) {
            date_of_withdraw_year.addItem(String.valueOf(i));
        }
        date_of_withdraw_year.setFont(SMALL_FONT);
        date_of_withdraw_year.setBounds(200, 150, 60, 30);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        date_of_withdraw_month = new JComboBox(months);
        date_of_withdraw_month.setFont(SMALL_FONT);
        date_of_withdraw_month.setBounds(265, 150, 60, 30);
        date_of_withdraw_day = new JComboBox();
        for (int i=1; i<=31; i++) {
            date_of_withdraw_day.addItem(String.valueOf(i));
        }
        date_of_withdraw_day.setFont(SMALL_FONT);
        date_of_withdraw_day.setBounds(330, 150, 50, 30);
        pin_number_db_lbl2 = new JLabel("PIN Number:");
        pin_number_db_lbl2.setFont(SMALL_FONT);
        pin_number_db_lbl2.setBounds(25, 190, 160, 30);
        pin_number_db_tf2 = new JTextField();
        pin_number_db_tf2.setFont(SMALL_FONT);
        pin_number_db_tf2.setBounds(200, 190, 160, 30);
        withdraw_button = new JButton("Withdraw");
        withdraw_button.setFont(SMALL_FONT);
        withdraw_button.setBounds(200, 230, 160, 30);
        withdraw_button.addActionListener(this);
        
        /* Subpanel 3 */
        // Heading
        db_miscellaneous_heading = new JLabel("Miscellaneous");
        db_miscellaneous_heading.setFont(BIG_FONT);
        db_miscellaneous_heading.setBounds(80, 15, 200, 50);
        /// Labels and text-fields        
        card_id_db_lbl3 = new JLabel("Card Id:");
        card_id_db_lbl3.setFont(SMALL_FONT);
        card_id_db_lbl3.setBounds(25, 75, 140, 30);
        card_id_db_tf3 = new JTextField();
        card_id_db_tf3.setFont(SMALL_FONT);
        card_id_db_tf3.setBounds(180, 75, 140, 30);
        db_display_btn = new JButton("Display");
        db_display_btn.setFont(SMALL_FONT);
        db_display_btn.setBounds(180, 150, 140, 30);
        db_display_btn.addActionListener(this);
        db_clear_btn = new JButton("Clear All");
        db_clear_btn.setFont(SMALL_FONT);
        db_clear_btn.setBounds(180, 190, 140, 30);
        db_clear_btn.addActionListener(this);

        // Add components to their respective subpanels
        panel2_sub1.add(db_card_heading);
        panel2_sub1.add(card_id_db_lbl1);
        panel2_sub1.add(balance_amount_db_lbl);
        panel2_sub1.add(issuer_bank_db_lbl);
        panel2_sub1.add(client_name_db_lbl);
        panel2_sub1.add(pin_number_db_lbl1);
        panel2_sub1.add(bank_account_db_lbl);
        panel2_sub1.add(card_id_db_tf1);
        panel2_sub1.add(balance_amount_db_tf);
        panel2_sub1.add(issuer_bank_db_tf);
        panel2_sub1.add(client_name_db_tf);
        panel2_sub1.add(pin_number_db_tf1);
        panel2_sub1.add(bank_account_db_tf);
        panel2_sub1.add(add_db_card_btn);
        panel2_sub1.add(db_go_back_btn);
        panel2_sub2.add(db_withdraw_heading);
        panel2_sub2.add(card_id_db_lbl2);
        panel2_sub2.add(card_id_db_tf2);
        panel2_sub2.add(withdraw_amount_db_lbl);
        panel2_sub2.add(withdraw_amount_db_tf);
        panel2_sub2.add(date_of_withdraw_lbl);
        panel2_sub2.add(date_of_withdraw_year);
        panel2_sub2.add(date_of_withdraw_month);
        panel2_sub2.add(date_of_withdraw_day);
        panel2_sub2.add(pin_number_db_lbl2);
        panel2_sub2.add(pin_number_db_tf2);
        panel2_sub2.add(withdraw_button);
        panel2_sub3.add(db_miscellaneous_heading);
        panel2_sub3.add(db_display_btn);
        panel2_sub3.add(card_id_db_lbl3);
        panel2_sub3.add(card_id_db_tf3);
        panel2_sub3.add(db_clear_btn);
        
        // Add the subpanels to panel2
        panel2.add(panel2_sub1);
        panel2.add(panel2_sub2);
        panel2.add(panel2_sub3);
    }
    
    // A private instance method to initialize and add the GUI components to panel3.
    private void create_panel3() {
        // Initialize panel3 (Credit Card Panel)
        panel3 = new JPanel();
        panel3.setBounds(0, 0, 800, 625);
        panel3.setLayout(null);
        panel3.setVisible(false);
        
        /* Initialize subpanels for panel3 */
        panel3_sub1 = new JPanel();
        panel3_sub1.setLayout(null);
        panel3_sub1.setBounds(15, 15, 755, 310);
        panel3_sub1.setBackground(BG_COLOR);
        panel3_sub2 = new JPanel();
        panel3_sub2.setLayout(null);
        panel3_sub2.setBounds(15, 340, 400, 235);
        panel3_sub2.setBackground(BG_COLOR);
        panel3_sub3 = new JPanel();
        panel3_sub3.setLayout(null);
        panel3_sub3.setBounds(425, 340, 345, 235);
        panel3_sub3.setBackground(BG_COLOR);
        
        /* Subpanel 1 */
        // Headings
        cr_card_heading = new JLabel("Credit Card");
        cr_card_heading.setFont(BIG_FONT);
        cr_card_heading.setBounds(300, 30, 300, 50);
        // Text-Labels
        card_id_cr_lbl1 = new JLabel("Card ID:");
        card_id_cr_lbl1.setFont(SMALL_FONT);
        card_id_cr_lbl1.setBounds(25, 100, 160, 25);
        balance_amount_cr_lbl = new JLabel("Balance Amount:");
        balance_amount_cr_lbl.setFont(SMALL_FONT);
        balance_amount_cr_lbl.setBounds(25, 135, 160, 25);
        bank_account_cr_lbl = new JLabel("Bank Account:");
        bank_account_cr_lbl.setFont(SMALL_FONT);
        bank_account_cr_lbl.setBounds(25, 170, 160, 25);
        interest_rate_cr_lbl = new JLabel("Interest Rate:");
        interest_rate_cr_lbl.setFont(SMALL_FONT);
        interest_rate_cr_lbl.setBounds(25, 205, 160, 25);
        issuer_bank_cr_lbl = new JLabel("Issuer Bank:");
        issuer_bank_cr_lbl.setFont(SMALL_FONT);
        issuer_bank_cr_lbl.setBounds(400, 100, 160, 25);
        client_name_cr_lbl = new JLabel("Client Name:");
        client_name_cr_lbl.setFont(SMALL_FONT);
        client_name_cr_lbl.setBounds(400, 135, 160, 25);
        cvc_number_cr_lbl = new JLabel("CVC Number:");
        cvc_number_cr_lbl.setFont(SMALL_FONT);
        cvc_number_cr_lbl.setBounds(400, 170, 160, 25);
        expire_date_lbl = new JLabel("Expire Date:");
        expire_date_lbl.setFont(SMALL_FONT);
        expire_date_lbl.setBounds(400, 205, 160, 25);
        // Text-Input-Fields
        card_id_cr_tf1 = new JTextField();
        card_id_cr_tf1.setFont(SMALL_FONT);
        card_id_cr_tf1.setBounds(180, 100, 160, 25);
        balance_amount_cr_tf = new JTextField();
        balance_amount_cr_tf.setFont(SMALL_FONT);
        balance_amount_cr_tf.setBounds(180, 135, 160, 25);
        bank_account_cr_tf = new JTextField();
        bank_account_cr_tf.setFont(SMALL_FONT);
        bank_account_cr_tf.setBounds(180, 170, 160, 25);
        interest_rate_cr_tf = new JTextField();
        interest_rate_cr_tf.setFont(SMALL_FONT);
        interest_rate_cr_tf.setBounds(180, 205, 160, 25);
        issuer_bank_cr_tf = new JTextField();
        issuer_bank_cr_tf.setFont(SMALL_FONT);
        issuer_bank_cr_tf.setBounds(560, 100, 160, 25);
        client_name_cr_tf = new JTextField();
        client_name_cr_tf.setFont(SMALL_FONT);
        client_name_cr_tf.setBounds(560, 135, 160, 25);
        cvc_number_cr_tf = new JTextField();
        cvc_number_cr_tf.setFont(SMALL_FONT);
        cvc_number_cr_tf.setBounds(560, 170, 160, 25);
        // ComboBox
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        expire_date_month = new JComboBox(months);
        expire_date_day = new JComboBox();
        for (int i=1; i<=31; i++) {
            expire_date_day.addItem(String.valueOf(i));
        }
        expire_date_year = new JComboBox();
        for (int i = 1960; i<=2023 ; i++) {
            expire_date_year.addItem(String.valueOf(i));
        }
        expire_date_year.setFont(SMALL_FONT);
        expire_date_month.setFont(SMALL_FONT);
        expire_date_month.setFont(SMALL_FONT);
        expire_date_year.setBounds(560, 205, 60, 30);
        expire_date_month.setBounds(625, 205, 60, 30);
        expire_date_day.setBounds(690, 205, 50, 30);
        // Buttons
        add_cr_card_btn = new JButton("Add Credit Card");
        add_cr_card_btn.setFont(SMALL_FONT);
        add_cr_card_btn.setBounds(400, 260, 180, 35);
        add_cr_card_btn.addActionListener(this);
        cr_go_back_btn = new JButton("Go Back");
        cr_go_back_btn.setFont(SMALL_FONT);
        cr_go_back_btn.setBounds(600, 260, 120, 35);
        cr_go_back_btn.addActionListener(this);
        
        /* Subpanel 2*/
        // Headings
        cr_set_creditLimit_heading = new JLabel("Set Credit Limit");
        cr_set_creditLimit_heading.setFont(BIG_FONT);
        cr_set_creditLimit_heading.setBounds(70, 15, 260, 50);
        // Labels and text-fields
        card_id_cr_lbl2 = new JLabel("Card Id:");
        card_id_cr_lbl2.setFont(SMALL_FONT);
        card_id_cr_lbl2.setBounds(25, 90, 160, 25);
        card_id_cr_tf2 = new JTextField();
        card_id_cr_tf2.setFont(SMALL_FONT);
        card_id_cr_tf2.setBounds(190, 90, 160, 25);
        credit_limit_cr_lbl = new JLabel("Credit Limit:");
        credit_limit_cr_lbl.setFont(SMALL_FONT);
        credit_limit_cr_lbl.setBounds(25, 125, 160, 25);
        credit_limit_cr_tf = new JTextField();
        credit_limit_cr_tf.setFont(SMALL_FONT);
        credit_limit_cr_tf.setBounds(190, 125, 160, 25);
        grace_period_cr_lbl = new JLabel("Grace Period:");
        grace_period_cr_lbl.setFont(SMALL_FONT);
        grace_period_cr_lbl.setBounds(25, 160, 160, 25);
        grace_period_cr_tf = new JTextField();
        grace_period_cr_tf.setFont(SMALL_FONT);
        grace_period_cr_tf.setBounds(190, 160, 160, 25);
        set_credit_limit_btn = new JButton("Set Credit Limit");
        set_credit_limit_btn.setFont(SMALL_FONT);
        set_credit_limit_btn.setBounds(160, 195, 200, 30);
        set_credit_limit_btn.addActionListener(this);
        
        /* Subpanel 3 */
        // Headings
        cr_miscellaneous_heading = new JLabel("Miscellaneous");
        cr_miscellaneous_heading.setFont(BIG_FONT);
        cr_miscellaneous_heading.setBounds(80, 15, 200, 50);
        // Labels and text-fields        
        card_id_cr_lbl3 = new JLabel("Card Id:");
        card_id_cr_lbl3.setFont(SMALL_FONT);
        card_id_cr_lbl3.setBounds(25, 75, 140, 30);
        card_id_cr_tf3 = new JTextField();
        card_id_cr_tf3.setFont(SMALL_FONT);
        card_id_cr_tf3.setBounds(180, 75, 140, 30);
        cr_display_btn = new JButton("Display");
        cr_display_btn.setFont(SMALL_FONT);
        cr_display_btn.setBounds(180, 150, 140, 30);
        cr_display_btn.addActionListener(this);
        cr_clear_btn = new JButton("Clear All");
        cr_clear_btn.setFont(SMALL_FONT);
        cr_clear_btn.setBounds(180, 190, 140, 30);
        cr_clear_btn.addActionListener(this);
        cancel_credit_btn = new JButton("Cancel Credit");
        cancel_credit_btn.setFont(SMALL_FONT);
        cancel_credit_btn.setBounds(25, 150, 150, 30);
        cancel_credit_btn.addActionListener(this);
        
        // Add the components to their respective subpanels.
        panel3_sub1.add(cr_card_heading);
        panel3_sub1.add(card_id_cr_lbl1);
        panel3_sub1.add(balance_amount_cr_lbl);
        panel3_sub1.add(bank_account_cr_lbl);
        panel3_sub1.add(issuer_bank_cr_lbl);
        panel3_sub1.add(client_name_cr_lbl);
        panel3_sub1.add(cvc_number_cr_lbl);
        panel3_sub1.add(interest_rate_cr_lbl);
        panel3_sub1.add(expire_date_lbl);
        panel3_sub1.add(card_id_cr_tf1);
        panel3_sub1.add(balance_amount_cr_tf);
        panel3_sub1.add(bank_account_cr_tf);
        panel3_sub1.add(issuer_bank_cr_tf);
        panel3_sub1.add(client_name_cr_tf);
        panel3_sub1.add(cvc_number_cr_tf);
        panel3_sub1.add(interest_rate_cr_tf);
        panel3_sub1.add(expire_date_year);
        panel3_sub1.add(expire_date_month);
        panel3_sub1.add(expire_date_day);
        panel3_sub1.add(add_cr_card_btn);
        panel3_sub1.add(cr_go_back_btn);        
        panel3_sub2.add(cr_set_creditLimit_heading);
        panel3_sub2.add(card_id_cr_lbl2);
        panel3_sub2.add(card_id_cr_tf2);
        panel3_sub2.add(credit_limit_cr_lbl);
        panel3_sub2.add(credit_limit_cr_tf);
        panel3_sub2.add(grace_period_cr_lbl);
        panel3_sub2.add(grace_period_cr_tf);
        panel3_sub2.add(set_credit_limit_btn);
        panel3_sub3.add(cr_miscellaneous_heading);
        panel3_sub3.add(card_id_cr_lbl3);
        panel3_sub3.add(card_id_cr_tf3);
        panel3_sub3.add(cr_display_btn);
        panel3_sub3.add(cr_clear_btn);
        panel3_sub3.add(cancel_credit_btn);
        
        // Add the subpanels to panel3
        panel3.add(panel3_sub1);
        panel3.add(panel3_sub2);
        panel3.add(panel3_sub3);
    }
    
    // A private instance method to finalize creating the GUI.
    private void create_GUI() {
        // Some Constants
        BG_COLOR = new Color(0xedd7a6);
        BIG_FONT = new Font("Consolas", Font.BOLD, 28);
        SMALL_FONT = new Font("Consolas", Font.PLAIN, 16);
    
        /* Initialize the frame */
        frame1 = new JFrame("BankGUI");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setBounds(50, 50, 800, 625);
        frame1.setLayout(null);
        frame1.setResizable(false);
        
        /* Create the panels and their components*/
        create_panel1(); // Main panel
        create_panel2(); // Debit Card panel
        create_panel3(); // Credit Card panel
        
        /* Add the panels to the frame */
        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(panel3);
        
        /* Set the visibility of only the first panel to be true */
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        
        // Set the visibility of the frame to be true.
        frame1.setVisible(true);
    }
    
    // Provide method implementation for actionPerformed() method of the ActionListener interface.
    public void actionPerformed(ActionEvent e) {
        // debit-card button
        if (e.getSource() == db_card_btn) {
            panel1.setVisible(false);
            panel2.setVisible(true);
        }
        
        // credit-card button
        else if (e.getSource() == cr_card_btn ) {
            panel1.setVisible(false);
            panel3.setVisible(true);
        }
        
        // go-back button
        else if (e.getSource() == db_go_back_btn || e.getSource() == cr_go_back_btn ) {
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel1.setVisible(true);
        }
        
        // clear button in debit card
        else if (e.getSource() == db_clear_btn) {
            card_id_db_tf1.setText("");
            card_id_db_tf2.setText("");
            card_id_db_tf3.setText("");
            balance_amount_db_tf.setText("");
            bank_account_db_tf.setText("");
            issuer_bank_db_tf.setText("");
            client_name_db_tf.setText("");
            pin_number_db_tf1.setText("");
            pin_number_db_tf2.setText("");
            withdraw_amount_db_tf.setText("");
        }
        
        // clear button in credit card
        else if (e.getSource() == cr_clear_btn) {
            card_id_cr_tf1.setText("");
            card_id_cr_tf2.setText("");
            card_id_cr_tf3.setText("");
            balance_amount_cr_tf.setText("");
            bank_account_cr_tf.setText("");
            issuer_bank_cr_tf.setText("");
            client_name_cr_tf.setText("");
            grace_period_cr_tf.setText("");
            credit_limit_cr_tf.setText("");
            cvc_number_cr_tf.setText("");
            interest_rate_cr_tf.setText("");
        }
        
        // add debit card button
        else if (e.getSource() == add_db_card_btn) {
                // Variables to store the values from the text fields.
                int card_id=0, pin_number=0;
                double balance_amount=0;
                String bank_account="", issuer_bank="", client_name="";
                
                // Variable to track whether to continue to add a debit card object.
                boolean _continue = true;
                                
                // Get the values from the text-fields with proper validation
                try {
                    card_id = Integer.valueOf(card_id_db_tf1.getText());
                    try {
                        balance_amount = Double.valueOf(balance_amount_db_tf.getText());
                        try {
                            pin_number = Integer.valueOf(pin_number_db_tf1.getText());
                        } catch(NumberFormatException nfe) {
                            _continue = false;
                            JOptionPane.showMessageDialog(panel2, "Incorrect format for PIN number. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch(NumberFormatException nfe) {
                        _continue = false;
                        JOptionPane.showMessageDialog(panel2, "Incorrect format for Balance Amount. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(NumberFormatException nfe) {
                    _continue = false;
                    JOptionPane.showMessageDialog(panel2, "Incorrect format for card ID. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                
                bank_account = bank_account_db_tf.getText();
                issuer_bank = issuer_bank_db_tf.getText();
                client_name = client_name_db_tf.getText();
                
                if (bank_account.length() == 0 && _continue) {
                    _continue = false;
                    JOptionPane.showMessageDialog(panel2, "Bank Account cannot be empty. Enter a valid value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                else if (issuer_bank.length() == 0 && _continue) {
                    _continue = false;
                    JOptionPane.showMessageDialog(panel2, "Issuer Bank cannot be empty. Enter a valid value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                else if (client_name.length() == 0 && _continue) {
                    _continue = false;
                    JOptionPane.showMessageDialog(panel2, "Client Name cannot be empty. Enter a valid value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                
                
                // Check for the duplication of DebitCard object before adding a new DebitCard object to the arraylist.
                if (_continue) {
                    for (BankCard b_obj : cardList) {
                        if (b_obj.getCardID() == card_id) {
                            _continue = false;
                            JOptionPane.showMessageDialog(panel2, "A bank card of the given card id: '" + card_id + "' already exists.", "Duplicate card", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                
                // Create a debit card from those object and then add the debit card object to the cardList arraylist.
                if (_continue) {
                    DebitCard newDebitCard = new DebitCard( balance_amount, card_id, bank_account, issuer_bank, client_name, pin_number);
                    cardList.add(newDebitCard);
                    JOptionPane.showMessageDialog(panel2, "The Debit Card has been added to the database. \n\tCardID: "+ card_id +
                        "\nBalance Amount:\t" + balance_amount +
                        "\nBank Account:\t" + bank_account +
                        "\nClient Name:\t" + client_name +
                        "\nPIN Number:\t" + pin_number, "Successfully Added A New Debit Card", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        
        // add credit card button
        else if (e.getSource() == add_cr_card_btn) {
            //Variables to store the values from the text fields.
            int card_id=0, cvc_number=0;
            double balance_amount=0, interest_rate=0;
            String bank_account="", issuer_bank="", client_name="", expire_date="";
                
            // Variable to track whether to continue to add the credit card object to the array list or not.
            boolean _continue = true;
                
            // Get values from the text field and combo box with proper validation.
            try {
                card_id = Integer.valueOf(card_id_cr_tf1.getText());
                try {
                    balance_amount = Double.valueOf(balance_amount_cr_tf.getText());
                    try {
                        cvc_number = Integer.valueOf(cvc_number_cr_tf.getText());
                        try {
                            interest_rate = Double.valueOf(interest_rate_cr_tf.getText());
                        } catch (NumberFormatException nfe) {
                            _continue = false;
                            JOptionPane.showMessageDialog(panel3, "Incorrect format for Interest Rate. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException nfe) {
                        _continue = false;
                        JOptionPane.showMessageDialog(panel3, "Incorrect format for CVC Number. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }   catch (NumberFormatException nfe) {
                    _continue = false;
                    JOptionPane.showMessageDialog(panel3, "Incorrect format for Balance Amount. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                _continue = false;
                JOptionPane.showMessageDialog(panel3, "Incorrect format for Card ID. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            bank_account = bank_account_cr_tf.getText();            
            issuer_bank = issuer_bank_cr_tf.getText();
            client_name = client_name_cr_tf.getText();
            if (bank_account.length() == 0 && _continue) {
                _continue = false;
                JOptionPane.showMessageDialog(panel3, "Bank Account cannot be empty. Please enter a valid value." , "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            else if (issuer_bank.length() == 0 && _continue) {
                _continue = false;
                JOptionPane.showMessageDialog(panel3, "Issuer Bank cannot be empty. Please enter a valid value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            else if (client_name.length() == 0 && _continue) {
                _continue = false;
                JOptionPane.showMessageDialog(panel3, "Client Name cannot be empty. Please enter a valid value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            expire_date = String.valueOf(expire_date_year.getSelectedItem()) + "/" + String.valueOf(expire_date_month.getSelectedItem()) + "/" + String.valueOf(expire_date_day.getSelectedItem());
            
            // Check for the duplication of CreditCard object before adding a new CreditCard object to the arraylist.
            if (_continue) {
                for (BankCard b_obj : cardList) {
                    if (b_obj.getCardID() == card_id) {
                        _continue = false;
                        JOptionPane.showMessageDialog(panel3, "A bank card of the given card id: '" + card_id + "' already exists.", "Duplicate card", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            //Create a credit card from those object and then add the credit card object to the cardList arraylist.
            if (_continue) {
                CreditCard newCreditCard = new CreditCard( card_id, client_name, issuer_bank, bank_account, balance_amount, cvc_number, interest_rate, expire_date);
                cardList.add(newCreditCard);
                String message = "The Credit Card has been added to the database. \n\tCardID: "+ card_id +
                "\nClient Name:\t" + client_name + 
                "\nIssuer Bank:\t"+issuer_bank + 
                "\nBank Account:\t"+bank_account + 
                "\nBalance Amount:\t"+balance_amount + 
                "\nCVC Number:\t"+cvc_number +
                "\nInterest Rate:\t"+interest_rate +
                "\nExpire Date:\t"+expire_date;
                JOptionPane.showMessageDialog(panel3, message, "Successfully Added A New Credit Card", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        // display button in debit card
        else if (e.getSource() == db_display_btn) {
            if (cardList.size() != 0) {
                int card_id = 0;
                boolean not_found = true;
                try {
                    card_id = Integer.valueOf(card_id_db_tf3.getText());
                    for (BankCard b_obj : cardList) {
                        if (b_obj instanceof DebitCard && b_obj.getCardID() == card_id) {
                            not_found = false;
                            DebitCard db_obj = (DebitCard) b_obj;
                            db_obj.displayInfo();
                        }
                    }
                } catch (NumberFormatException nfe) {
                    not_found = false;
                    JOptionPane.showMessageDialog(panel2, "Incorrect format for Card ID. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                
                if (not_found) {
                    JOptionPane.showMessageDialog(panel2, "A debit card of given Card ID doesn't exist on the database.", "Card Not Found", JOptionPane.WARNING_MESSAGE);
                }
            } 
            else {
                JOptionPane.showMessageDialog(panel2, "Database is empty! No card entries found.", "Empty Database", JOptionPane.ERROR_MESSAGE);
            } 
        }
        
        // display button in credit card
        else if (e.getSource() == cr_display_btn) {
            if (cardList.size() != 0) {
                int card_id = 0;
                boolean not_found = true;
                try {
                    card_id = Integer.valueOf(card_id_cr_tf3.getText());
                    for (BankCard b_obj : cardList) {
                        if (b_obj instanceof CreditCard && b_obj.getCardID() == card_id) {
                            not_found = false;
                            CreditCard cr_obj = (CreditCard) b_obj;
                            if (cr_obj.getIsGranted()) {
                                cr_obj.displayInfo();
                            }
                            else {
                                JOptionPane.showMessageDialog(panel3, "Please set credit limit first before displaying the credit card.", "Credit Limit Not Set", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                    not_found = false;
                    JOptionPane.showMessageDialog(panel3, "Format of card_id is invalid", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
                                
                if (not_found) {
                    JOptionPane.showMessageDialog(panel3, "A credit card of given Card ID doesn't exist on the database.", "Card Number not found", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(panel3, "Database is empty! No card entries found.", "Empty Database", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // withdraw button in debit card
        else if (e.getSource() == withdraw_button) {
            // Variables to store values from the text-fields.
            int card_id=0, pin_number=0, withdraw_amount=0;
            String date_of_withdraw = "";
            boolean not_found = true; // Variable to track whether to display error message that debit_card is not found or not.
    
            if (cardList.size() != 0) {
                // Assign the values to the variables with proper input validation
                try {
                    card_id = Integer.valueOf(card_id_db_tf2.getText());
                    try {
                        pin_number = Integer.valueOf(pin_number_db_tf2.getText());
                        try {
                            withdraw_amount = Integer.valueOf(withdraw_amount_db_tf.getText());
                            date_of_withdraw = String.valueOf(date_of_withdraw_year.getSelectedItem()) + "/" + String.valueOf(date_of_withdraw_month.getSelectedItem()) + "/" + String.valueOf(date_of_withdraw_day.getSelectedItem());
                            for (BankCard b_obj: cardList ) {
                                if (b_obj instanceof DebitCard && b_obj.getCardID() == card_id) {
                                    DebitCard db_obj = (DebitCard) b_obj;
                                    not_found = false;
                                    
                                    if (db_obj.getPIN() != pin_number) {
                                        JOptionPane.showMessageDialog(panel2, "The PIN number of given card is incorrect." ,"Invalid PIN", JOptionPane.ERROR_MESSAGE);
                                    }
                                    //else if (db_obj.getBalanceAmount() < withdraw_amount) {
                                    //    JOptionPane.showMessageDialog(panel2, "The balance amount is insufficient for the withdraw.", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
                                    //}
                                    else {
                                        String message = "Successfully withdrawn money from the Debit Card. \nCardID:\t" + card_id +
                                            "\nWithdraw Amount:\t" + withdraw_amount +
                                            "\nPIN Number:\t" + pin_number +
                                            "\nDate Of Withdraw:\t" + date_of_withdraw;
                                        JOptionPane.showMessageDialog(panel2, message, "Withdraw Successful", JOptionPane.INFORMATION_MESSAGE);
                                        db_obj.withdraw(withdraw_amount, date_of_withdraw, pin_number);
                                    }
                                }
                            }
                        } catch (NumberFormatException nfe) {
                            not_found = false;
                            JOptionPane.showMessageDialog(panel2, "Format of withdraw_amount input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException nfe) {
                        not_found = false;
                        JOptionPane.showMessageDialog(panel2, "Format of pin_number input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException nfe) {
                    not_found = false;
                    JOptionPane.showMessageDialog(panel2, "Format of card_id input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                }
                
                if (not_found) {
                    JOptionPane.showMessageDialog(panel2, "A debit card of given Card ID doesn't exist on the database.", "Card Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(panel2, "Database is empty! No card entries found.", "Empty Database", JOptionPane.ERROR_MESSAGE);
            }
        }
        // set-credit-limit button in credit card
        else if (e.getSource() == set_credit_limit_btn) {
            // Variables to store values from the text-fields.
            int card_id=0, grace_period=0;
            double credit_limit = 0;
            boolean not_found = true; // Variable to track whether to display error message that credit card is not found or not.
            if (cardList.size() != 0) {
                // Assign the variables,  values from the text-fields.
                try {
                    card_id = Integer.valueOf(card_id_cr_tf2.getText());
                    try {
                        credit_limit = Double.valueOf(credit_limit_cr_tf.getText());
                        try {
                            grace_period = Integer.valueOf(grace_period_cr_tf.getText());
                            for (BankCard b_obj: cardList ) {
                                if (b_obj instanceof CreditCard && b_obj.getCardID() == card_id) {
                                    CreditCard cr_obj = (CreditCard) b_obj;
                                    double balance_amount = cr_obj.getBalanceAmount();
                                    not_found = false;
                                    if (credit_limit <= (2.5 * balance_amount)) {
                                        String message = "A new credit limit has been set successfully. " + 
                                        "\nCard ID: " + card_id +
                                        "\nCredit Limit: " + credit_limit +
                                        "\nGrace Period: " + grace_period ;
                                        cr_obj.setCredit(credit_limit, grace_period);
                                        JOptionPane.showMessageDialog(panel3, message, "New Credit Limit Has Been Set", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(panel3, "Insufficient Balance to issue the credit.", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        } catch (NumberFormatException nfe) {
                            not_found = false;
                            JOptionPane.showMessageDialog(panel3, "Format of grace_period input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException nfe) {
                        not_found = false;
                        JOptionPane.showMessageDialog(panel3, "Format of credit_card input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException nfe) {
                    not_found = false;
                    JOptionPane.showMessageDialog(panel3, "Format of pin_number input field is incorrect.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                }
                
                if (not_found){
                    JOptionPane.showMessageDialog(panel3, "A credit card of given Card ID doesn't exist on the database.", "Card Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(panel3, "Database is empty! No card entries found.", "Empty Database", JOptionPane.ERROR_MESSAGE);                
            }    
        }
        
        // cancel-credit button in credit card
        else if (e.getSource() == cancel_credit_btn) {
            if (cardList.size() != 0) {
                int card_id = 0;
                boolean not_found = true; // Variable to track whether to display error message that credit card is not found or not.
                try {
                    card_id = Integer.valueOf(card_id_cr_tf3.getText());
                    for (BankCard b_obj: cardList) {
                        if (b_obj instanceof CreditCard && b_obj.getCardID() == card_id) {
                            String message = "The credit card with given Card ID: " + card_id + "has been cancelled.";
                            not_found = false;
                            CreditCard cr_obj = (CreditCard) b_obj;
                            cr_obj.cancelCreditCard();
                            JOptionPane.showMessageDialog(panel3, message, "Cancellation Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (NumberFormatException nfe) {
                    not_found = false;
                    JOptionPane.showMessageDialog(panel3, "Incorrect format for Card ID. Please enter correct format.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                
                if(not_found) {
                    JOptionPane.showMessageDialog(panel3, "A credit card of given Card ID doesn't exist on the database.", "Card Number not found", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(panel3, "Database is empty! No card entries found.", "Empty Database", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Main method
    public static void main (String[] args) {
        // Create an instance of the BankGUI class
        BankGUI BANK = new BankGUI();
        BANK.create_GUI();
    }
}
