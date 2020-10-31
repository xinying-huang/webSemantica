package webSemantica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtNmeroDeArchivo;
	private JTextField txtTamaoSolar;
	private JTextField txtDistrito;
	private JTextField txtZonasVerdes;
	private JTextField txtGrupo;
	private JTextField numArchivofield;
	private JTextField rango1;
	private JTextField rango2;
	private JLabel lblM;
	private JPanel panelbusqueda;
	private JComboBox distritofield;
	private JLabel guion;
	private JButton btnConsultar;
	private JScrollPane panelresultado;
	private JButton btnVolver;
	private JLabel icono;
	private JTextArea resultados;
	private JTextArea opciones;
	private JScrollPane panelopciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//----------------------------------------------------------------------		
		panelresultado = new JScrollPane();
		panelresultado.setBounds(10, 192, 702, 239);
		panelresultado.setVisible(false);
		
		//--------------------------------------------------------------------
		panelbusqueda = new JPanel();
		panelbusqueda.setBorder(null);
		panelbusqueda.setBackground(Color.WHITE);
		panelbusqueda.setBounds(10, 125, 702, 349);
		contentPane.add(panelbusqueda);
		panelbusqueda.setLayout(null);
		//--------------------------------------------------------------------				
		txtNmeroDeArchivo = new JTextField();
		txtNmeroDeArchivo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNmeroDeArchivo.setBackground(Color.WHITE);
		txtNmeroDeArchivo.setEditable(false);
		txtNmeroDeArchivo.setHorizontalAlignment(SwingConstants.LEFT);
		txtNmeroDeArchivo.setText("N\u00FAmero de Archivo : ");
		txtNmeroDeArchivo.setBounds(28, 84, 168, 41);
		txtNmeroDeArchivo.setBorder(null);
		panelbusqueda.add(txtNmeroDeArchivo);
		txtNmeroDeArchivo.setColumns(10);
		//--------------------------------------------------------------------
		txtDistrito = new JTextField();
		txtDistrito.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDistrito.setBackground(Color.WHITE);
		txtDistrito.setEditable(false);
		txtDistrito.setHorizontalAlignment(SwingConstants.LEFT);
		txtDistrito.setText("Distrito : ");
		txtDistrito.setBounds(28, 207, 74, 41);
		txtDistrito.setBorder(null);
		panelbusqueda.add(txtDistrito);
		txtDistrito.setColumns(10);
		//--------------------------------------------------------------------
		txtTamaoSolar = new JTextField();
		txtTamaoSolar.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTamaoSolar.setBackground(Color.WHITE);
		txtTamaoSolar.setEditable(false);
		txtTamaoSolar.setHorizontalAlignment(SwingConstants.LEFT);
		txtTamaoSolar.setText("Tama\u00F1o Solar : ");
		txtTamaoSolar.setBounds(28, 267, 134, 42);
		txtTamaoSolar.setBorder(null);
		panelbusqueda.add(txtTamaoSolar);
		txtTamaoSolar.setColumns(10);
		//--------------------------------------------------------------------
		distritofield = new JComboBox();
		distritofield.setForeground(Color.WHITE);
		distritofield.setBackground(new Color(0, 139,139));
		distritofield.setBounds(112, 218, 98, 22);
		distritofield.setModel(new DefaultComboBoxModel(new String[] {"Centro", "Arganzuela"}));
		panelbusqueda.add(distritofield);
		//--------------------------------------------------------------------
		numArchivofield = new JTextField();
		numArchivofield.setBounds(207, 96, 96, 20);
		panelbusqueda.add(numArchivofield);
		numArchivofield.setColumns(10);
		numArchivofield.setBorder(new LineBorder(new Color(0, 139,139), 2, true));
		//--------------------------------------------------------------------
		rango1 = new JTextField();
		rango1.setBounds(167, 279, 96, 20);
		panelbusqueda.add(rango1);
		rango1.setColumns(10);
		rango1.setBorder(new LineBorder(new Color(0, 139,139), 2, true));
		//--------------------------------------------------------------------
		rango2 = new JTextField();
		rango2.setBounds(290, 279, 96, 20);
		panelbusqueda.add(rango2);
		rango2.setColumns(10);
		rango2.setBorder(new LineBorder(new Color(0, 139,139), 2, true));
		//--------------------------------------------------------------------
		guion = new JLabel("-");
		guion.setFont(new Font("Tahoma", Font.BOLD, 15));
		guion.setBounds(273, 276, 7, 22);
		panelbusqueda.add(guion);
		//--------------------------------------------------------------------
		lblM = new JLabel("m2");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setBounds(396, 276, 26, 22);
		panelbusqueda.add(lblM);
		
		JLabel lblNewLabel = new JLabel("Puedes utilizar las siguientes opciones para filtrar las zonas verdes.");
		lblNewLabel.setForeground(new Color(51, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(28, 169, 568, 27);
		panelbusqueda.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puedes buscar una zona verde por su n\u00FAmero de archivo.");
		lblNewLabel_1.setForeground(new Color(51, 153, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(28, 38, 483, 27);
		panelbusqueda.add(lblNewLabel_1);
		panelresultado.setBorder(new LineBorder(new Color(0, 139,139), 2, true));
		resultados = new JTextArea();
		resultados.setFont(new Font("Monospaced", Font.PLAIN, 15));
		resultados.setText("Aqui estan los resultados:");
		panelresultado.setViewportView(resultados);
		contentPane.add(panelresultado);
		//----------------------------------------------------------------------
		panelopciones = new JScrollPane();
		panelopciones.setBounds(10, 137, 702, 57);
		contentPane.add(panelopciones);
		panelopciones.setVisible(false);
		
		opciones = new JTextArea();
		opciones.setFont(new Font("Monospaced", Font.PLAIN, 15));
		opciones.setText("Los resultados filtrados por :");
		panelopciones.setViewportView(opciones);
		panelopciones.setBorder(new LineBorder(new Color(0, 139,139), 2, true));
		//--------------------------------------------------------------------
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(310, 485, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(0, 139, 139));
		btnVolver.setBounds(10, 485, 696, 23);
		btnVolver.setVisible(false);
		//--------------------------------------------------------------------
		btnConsultar = new JButton("Consultar");		
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(0, 139, 139));
		btnConsultar.setBounds(10, 485, 696, 23);
		contentPane.add(btnConsultar);
		//--------------------------------------------------------------------
		icono = new JLabel("");
		icono.setIcon(new ImageIcon("C:\\uni\\uniweb\\webSemantica\\icono.jpg"));
		icono.setBounds(460, 32, 91, 94);
		contentPane.add(icono);
		//--------------------------------------------------------------------
		txtZonasVerdes = new JTextField();
		txtZonasVerdes.setForeground(new Color(0, 139, 139));
		txtZonasVerdes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtZonasVerdes.setBackground(Color.WHITE);
		txtZonasVerdes.setEditable(false);
		txtZonasVerdes.setHorizontalAlignment(SwingConstants.CENTER);
		txtZonasVerdes.setBounds(182, 57, 320, 57);
		txtZonasVerdes.setText("ZONAS VERDES");
		txtZonasVerdes.setBorder(null);
		contentPane.add(txtZonasVerdes);
		txtZonasVerdes.setColumns(10);
		//--------------------------------------------------------------------
		txtGrupo = new JTextField();
		txtGrupo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtGrupo.setForeground(new Color(0, 139, 139));
		txtGrupo.setBackground(Color.WHITE);
		txtGrupo.setEditable(false);
		txtGrupo.setText("Grupo 56");
		txtGrupo.setBounds(10, 11, 96, 20);
		txtGrupo.setBorder(null);
		contentPane.add(txtGrupo);
		txtGrupo.setColumns(10);		
		//----------------------------------------------------------------
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelbusqueda.setVisible(false);
				btnConsultar.setVisible(false);
				panelresultado.setVisible(true);
				panelopciones.setVisible(true);
				btnVolver.setVisible(true);
				//-----------------------------
				
				
			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelbusqueda.setVisible(true);
				btnConsultar.setVisible(true);
				panelresultado.setVisible(false);
				panelopciones.setVisible(false);
				btnVolver.setVisible(false);
				//------------------------------
				numArchivofield.setText(null);
				rango1.setText(null);
				rango2.setText(null);
			}
		});
	}
}
