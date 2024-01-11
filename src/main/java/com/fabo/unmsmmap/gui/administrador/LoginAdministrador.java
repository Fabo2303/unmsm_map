package com.fabo.unmsmmap.gui.administrador;

import javax.swing.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fabo.unmsmmap.gui.gestion.Usuario;
import com.fabo.unmsmmap.utilidades.CargaImagen;
import com.fabo.unmsmmap.utilidades.CustomButton;
import com.fabo.unmsmmap.utilidades.Formato;
import com.fabo.unmsmmap.utilidades.ImagePanel;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LoginAdministrador {
	private ImagePanel imagePanel;
	private SpringLayout springLayout;
	private JLabel titleLabel, userLabel, passwordLabel, logo;
	private JTextField userTextField, passwordTextField;
	private CustomButton ingresarButton;
	private Usuario[] usuarios;

	public LoginAdministrador() {
		imagePanel = ImagePanel.getInstance();
		springLayout = new SpringLayout();
		imagePanel.setLayout(springLayout);
		iniciarUsuarios();
		initComponentes();
		addResizeListener();
	}

	private void iniciarUsuarios() {
		try (FileReader fileReader = new FileReader(RutasArchivos.USUARIOS_FILE)) {
			Gson gson = new GsonBuilder().create();
			usuarios = gson.fromJson(fileReader, Usuario[].class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initComponentes() {
		labelTitulo();
		labelUsuario();
		textFieldUsuario();
		labelContrasenya();
		textFieldContrasenya();
		buttonIngresar();
		logo();
	}

	private void updatePositionComponents() {
		updatePositionLabelTitulo();
		updatePositionLabelUsuario();
		updatePositionTextFieldUsuario();
		updatePositionLabelContrasenya();
		updatePositionTextFieldContrasenya();
		updatePositionButtonIngresar();
		updatePositionLogo();
	}

	private void labelTitulo() {
		titleLabel = new JLabel("LOGIN DE ADMINISTRADOR");
		titleLabel.setPreferredSize(new Dimension(800, 40));
		Formato.formato(titleLabel, 1, 45f);
		updatePositionLabelTitulo();
		imagePanel.add(titleLabel);
	}

	private void updatePositionLabelTitulo() {
		springLayout.putConstraint(SpringLayout.WEST, titleLabel,
				(int) ((imagePanel.getWidth() - titleLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, titleLabel,
				200, SpringLayout.NORTH, imagePanel);
	}

	private void labelUsuario() {
		userLabel = new JLabel("Correo");
		userLabel.setPreferredSize(new Dimension(140, 40));
		Formato.formato(userLabel, 1, 32f);
		updatePositionLabelUsuario();
		imagePanel.add(userLabel);
	}

	private void updatePositionLabelUsuario() {
		springLayout.putConstraint(SpringLayout.WEST, userLabel,
				(int) ((imagePanel.getWidth() - userLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, userLabel,
				300, SpringLayout.NORTH, imagePanel);
	}

	private void textFieldUsuario() {
		userTextField = new JTextField("Ingrese su usuario");
		userTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(userTextField, 0, 28f);
		userTextField.setForeground(Color.gray);
		userTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (userTextField.getText().equals("Ingrese su usuario")) {
					userTextField.setText("");
					userTextField.setForeground(Color.WHITE);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (userTextField.getText().isEmpty()) {
					userTextField.setText("Ingrese su usuario");
					userTextField.setForeground(Color.GRAY);
				}
			}
		});
		updatePositionTextFieldUsuario();
		imagePanel.add(userTextField);
	}

	private void updatePositionTextFieldUsuario() {
		springLayout.putConstraint(SpringLayout.WEST, userTextField,
				(int) ((imagePanel.getWidth() - userTextField.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, userTextField,
				340, SpringLayout.NORTH, imagePanel);
	}

	private void labelContrasenya() {
		passwordLabel = new JLabel("Contraseña");
		passwordLabel.setPreferredSize(new Dimension(200, 40));
		Formato.formato(passwordLabel, 1, 32f);
		updatePositionLabelContrasenya();
		imagePanel.add(passwordLabel);
	}

	private void updatePositionLabelContrasenya() {
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel,
				(int) ((imagePanel.getWidth() - passwordLabel.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel,
				400, SpringLayout.NORTH, imagePanel);
	}

	private void textFieldContrasenya() {
		passwordTextField = new JPasswordField("..............");
		passwordTextField.setPreferredSize(new Dimension(300, 40));
		Formato.formato(passwordTextField, 0, 28f);
		passwordTextField.setForeground(Color.gray);
		passwordTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (passwordTextField.getText().equals("..............")) {
					passwordTextField.setText("");
					passwordTextField.setForeground(Color.WHITE);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (passwordTextField.getText().isEmpty()) {
					passwordTextField.setText("..............");
					passwordTextField.setForeground(Color.GRAY);
				}
			}
		});
		updatePositionTextFieldContrasenya();
		imagePanel.add(passwordTextField);
	}

	private void updatePositionTextFieldContrasenya() {
		springLayout.putConstraint(SpringLayout.WEST, passwordTextField,
				(int) ((imagePanel.getWidth() - passwordTextField.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, passwordTextField,
				440, SpringLayout.NORTH, imagePanel);
	}

	private void buttonIngresar() {
		ingresarButton = new CustomButton("INGRESAR");
		ingresarButton.setPreferredSize(new Dimension(200, 40));
		Formato.formato(ingresarButton, 0, 25f, 10, 2);
		ingresarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = userTextField.getText().replace(" ", "");
				String password = passwordTextField.getText().replace(" ", "");
				if (!usuario.isEmpty() && !password.isEmpty()) {
					if (validar(usuario, password)) {
						imagePanel.removeAll();
						new PantallaMenuAdmin();
						imagePanel.repaint();
						imagePanel.revalidate();
					}
				}
			}
		});
		updatePositionButtonIngresar();
		imagePanel.add(ingresarButton);
	}

	private void updatePositionButtonIngresar() {
		springLayout.putConstraint(SpringLayout.WEST, ingresarButton,
				(int) ((imagePanel.getWidth() - ingresarButton.getPreferredSize().getWidth()) / 2),
				SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, ingresarButton,
				540, SpringLayout.NORTH, imagePanel);
	}

	private boolean validar(String user, String password) {
		return Arrays.stream(usuarios)
				.anyMatch(usuario -> usuario.getUser().equals(user) && usuario.getPassword().equals(password));
	}

	private void logo() {
		logo = new JLabel("Logo");
		logo.setPreferredSize(new Dimension(148, 148));
		CargaImagen.setImagen(logo, RutasArchivos.LOGO);
		Formato.formato(logo, 0, 40f);
		logo.setOpaque(true);
		updatePositionLogo();
		imagePanel.add(logo);
	}

	private void updatePositionLogo() {
		springLayout.putConstraint(SpringLayout.WEST, logo,
				(int) ((imagePanel.getWidth() - logo.getPreferredSize().getWidth()) / 2), SpringLayout.WEST,
				imagePanel);
		springLayout.putConstraint(SpringLayout.NORTH, logo,
				10, SpringLayout.NORTH, imagePanel);
	}

	private void addResizeListener() {
		imagePanel.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				updatePositionComponents();
				imagePanel.repaint();
				imagePanel.revalidate();
			}
		});
	}
}
