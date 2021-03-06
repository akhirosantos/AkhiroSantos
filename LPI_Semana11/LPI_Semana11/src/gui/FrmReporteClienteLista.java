package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import entidad.Director;
import model.ClienteModel;
import model.DirectorModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sql.DataSource;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class FrmReporteClienteLista extends JFrame implements ActionListener {
	private JLabel lblListaDeClientes;
	private JButton btnFiltrar;
	private JPanel panelReporte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClienteLista frame = new FrmReporteClienteLista();
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
	public FrmReporteClienteLista() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 593);
		getContentPane().setLayout(null);
		
		lblListaDeClientes = new JLabel("LISTA DE CLIENTES");
		lblListaDeClientes.setForeground(Color.WHITE);
		lblListaDeClientes.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeClientes.setBounds(10, 37, 1004, 28);
		getContentPane().add(lblListaDeClientes);
		
		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBackground(Color.DARK_GRAY);
		btnFiltrar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnFiltrar.setBounds(10, 76, 1005, 33);
		getContentPane().add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(10, 120, 1005, 423);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		ClienteModel model = new ClienteModel();
		List<Cliente> data = model.listaCliente();
		
		JRBeanCollectionDataSource dataSource 
				= new JRBeanCollectionDataSource(data);

	
		String file = "reporteCliente.jasper";
		

		JasperPrint jasperPrint =
			GeneradorReporte.genera(file, dataSource, null);

	
		JRViewer jRViewer = new JRViewer(jasperPrint);
		

		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
