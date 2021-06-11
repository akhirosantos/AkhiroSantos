package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Director;
import entidad.TipoCliente;
import util.MySqlDBConexion;

@SuppressWarnings("unused")
public class ClienteModel {
	
	public List<Cliente> consultaCliente(String numero){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre "
						+ "from cliente c inner join tipo_cliente tc "
						+ "on c.idTipoCliente = tc.idTpoCliente " 
						+ "where c.dni like '"+numero+"%'";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Cliente objCliente = null;
			TipoCliente objTipoCliente = null;
			
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getString(4));
				objCliente.setFechaNacimiento(rs.getDate(5));
				
				objTipoCliente = new TipoCliente();
				objTipoCliente.setNombre(rs.getString(6));
				
				objCliente.setIdTipoCliente(objTipoCliente);
				data.add(objCliente);
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)pstm.close();
					if (con != null)con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return data;
		}
	
	public List<Cliente> listaCliente(){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre "
						+ "from cliente c inner join tipo_cliente tc "
						+ "on c.idTipoCliente = tc.idTpoCliente ";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Cliente objCliente = null;
			TipoCliente objTipoCliente = null;
			
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getString(4));
				objCliente.setFechaNacimiento(rs.getDate(5));
				
				objTipoCliente = new TipoCliente();
				objTipoCliente.setNombre(rs.getString(6));
				
				objCliente.setIdTipoCliente(objTipoCliente);
				data.add(objCliente);
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)pstm.close();
					if (con != null)con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return data;
		}
}

	