package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

@SuppressWarnings({ "serial", "unused" })
public class FrmReporteClienteConsulta extends JFrame implements ActionListener {
	private JLabel lblConsultaDeCliente;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JButton btnFiltrar;
	private JPanel panelReporte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClienteConsulta frame = new FrmReporteClienteConsulta();
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
	public FrmReporteClienteConsulta() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 592);
		getContentPane().setLayout(null);
		
		lblConsultaDeCliente = new JLabel("CONSULTA DE CLIENTE POR DNI");
		lblConsultaDeCliente.setForeground(Color.WHITE);
		lblConsultaDeCliente.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblConsultaDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeCliente.setBounds(10, 28, 826, 29);
		getContentPane().add(lblConsultaDeCliente);
		
		lblDni = new JLabel("DNI:");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblDni.setBounds(150, 80, 46, 14);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtDNI.setBounds(243, 78, 338, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBackground(Color.DARK_GRAY);
		btnFiltrar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnFiltrar.setBounds(651, 77, 121, 23);
		getContentPane().add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(10, 113, 962, 429);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String numero = txtDNI.getText().trim();
		
		ClienteModel model = new ClienteModel();
		List<Cliente> lstData = null;
		if(numero.equals("")) {
			lstData = model.listaCliente();
		}else {
			lstData = model.consultaCliente(numero);
		}
		
		JRBeanCollectionDataSource dataSource
			= new JRBeanCollectionDataSource(lstData);
		
		String file = "reporteCliente.jasper";
		
		JasperPrint jasperPrint = 
				GeneradorReporte.genera(file, dataSource, null);
		
		JRViewer jrViewer = new JRViewer(jasperPrint);
		
		panelReporte.removeAll();
		panelReporte.add(jrViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
