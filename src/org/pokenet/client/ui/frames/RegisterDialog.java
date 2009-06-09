package org.pokenet.client.ui.frames;

import java.util.List;
import java.util.regex.Pattern;

import mdes.slick.sui.Button;
import mdes.slick.sui.Frame;
import mdes.slick.sui.Label;
import mdes.slick.sui.TextField;
import mdes.slick.sui.ToggleButton;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.pokenet.client.GameClient;
import org.pokenet.client.backend.Translator;

/**
 * Handles registration dialog
 * @author shadowkanji
 *
 */
public class RegisterDialog extends Frame{
	private TextField m_username, m_password, m_confirmPass, m_email, m_confirmEmail, m_day, m_month, m_year;
	private ToggleButton [] m_starters;
	private Label m_u, m_p, m_cp, m_d, m_e, m_ce, m_s, m_g, m_tos;
	private Button m_register, m_cancel, m_male, m_female, m_terms;
	private int m_starter = 1;
	private int m_gender = 0;
	private Color m_white = new Color(255, 255, 255);
	
	/**
	 * Default constructor
	 */
	public RegisterDialog() {
		List<String> translated = Translator.translate("_LOGIN");
		this.setVisible(false);
		this.setSize(320, 320);
		this.setBackground(new Color(0, 0, 0, 120));
		this.setTitle(translated.get(9));
		this.getTitleBar().getCloseButton().setVisible(false);
		this.setLocation(420, 220);
		this.setResizable(false);
		this.setDraggable(false);
		
		m_u = new Label(translated.get(5));
		m_u.pack();
		m_u.setLocation(4, 4);
		m_u.setFont(GameClient.getFontSmall());
		m_u.setForeground(m_white);
		this.add(m_u);
		
		m_username = new TextField();
		m_username.setSize(128, 24);
		m_username.setLocation(4, 24);
		m_username.setVisible(true);
		m_username.grabFocus();
		this.add(m_username);
		
		m_p = new Label(translated.get(6));
		m_p.pack();
		m_p.setLocation(4, 52);
		m_p.setFont(GameClient.getFontSmall());
		m_p.setForeground(m_white);
		this.add(m_p);
		
		m_password = new TextField();
		m_password.setSize(128, 24);
		m_password.setLocation(4, 72);
		m_password.setMaskCharacter('*');
		m_password.setMaskEnabled(true);
		m_password.setVisible(true);
		this.add(m_password);
		
		m_cp = new Label(translated.get(10));
		m_cp.pack();
		m_cp.setLocation(4, 100);
		m_cp.setFont(GameClient.getFontSmall());
		m_cp.setForeground(m_white);
		this.add(m_cp);
		
		m_confirmPass = new TextField();
		m_confirmPass.setSize(128, 24);
		m_confirmPass.setLocation(4, 122);
		m_confirmPass.setMaskCharacter('*');
		m_confirmPass.setMaskEnabled(true);
		m_confirmPass.setVisible(true);
		this.add(m_confirmPass);
		
		m_d = new Label(translated.get(11));
		m_d.pack();
		m_d.setLocation(4, 152);
		m_d.setFont(GameClient.getFontSmall());
		m_d.setForeground(m_white);
		this.add(m_d);
		
		m_day = new TextField();
		m_day.setSize(32, 24);
		m_day.setLocation(4, 172);
		m_day.setVisible(true);
		this.add(m_day);
		
		m_month = new TextField();
		m_month.setSize(32, 24);
		m_month.setLocation(40, 172);
		m_month.setVisible(true);
		this.add(m_month);
		
		m_year = new TextField();
		m_year.setSize(52, 24);
		m_year.setLocation(76, 172);
		m_year.setVisible(true);
		this.add(m_year);
		
		m_e = new Label(translated.get(12));
		m_e.pack();
		m_e.setLocation(4, 202);
		m_e.setFont(GameClient.getFontSmall());
		m_e.setForeground(m_white);
		this.add(m_e);
		
		m_email = new TextField();
		m_email.setSize(128, 24);
		m_email.setLocation(4, 220);
		m_email.setVisible(true);
		this.add(m_email);
		
		m_ce = new Label(translated.get(13));
		m_ce.pack();
		m_ce.setLocation(4, 248);
		m_ce.setFont(GameClient.getFontSmall());
		m_ce.setForeground(m_white);
		this.add(m_ce);
		
		m_confirmEmail = new TextField();
		m_confirmEmail.setSize(128, 24);
		m_confirmEmail.setLocation(4, 268);
		m_confirmEmail.setVisible(true);
		this.add(m_confirmEmail);
		
		m_s = new Label(translated.get(14));
		m_s.pack();
		m_s.setLocation(170, 4);
		m_s.setFont(GameClient.getFontSmall());
		m_s.setForeground(m_white);
		this.add(m_s);
		
		this.generateStarters();
		
		m_g = new Label(translated.get(15));
		m_g.pack();
		m_g.setLocation(170, 128);
		m_g.setFont(GameClient.getFontSmall());
		m_g.setForeground(m_white);
		this.add(m_g);
		
		m_male = new Button(translated.get(16));
		m_male.setSize(64, 24);
		m_male.setLocation(170, 150);
		m_male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m_female.setEnabled(true);
				m_gender = 0;
				m_male.setEnabled(false);
			}
		});
		this.add(m_male);
		
		m_female = new Button(translated.get(17));
		m_female.setSize(64, 24);
		m_female.setLocation(234, 150);
		m_female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m_female.setEnabled(false);
				m_gender = 1;
				m_male.setEnabled(true);
			}
		});
		this.add(m_female);
		
		m_tos = new Label(translated.get(18));
		m_tos.pack();
		m_tos.setLocation(170, 182);
		m_tos.setFont(GameClient.getFontSmall());
		m_tos.setForeground(m_white);
		this.add(m_tos);
		
		m_terms = new Button(translated.get(19));
		m_terms.setSize(128, 24);
		m_terms.setLocation(170, 204);
		m_terms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m_terms.setEnabled(false);
			}
		});
		this.add(m_terms);
		
		m_register = new Button(translated.get(8));
		m_register.setSize(64, 32);
		m_register.setLocation(188, 254);
		m_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register();
			}
		});
		this.add(m_register);
		
		m_cancel = new Button(translated.get(20));
		m_cancel.setSize(64, 32);
		m_cancel.setLocation(252, 254);
		m_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}
		});
		this.add(m_cancel);
	}
	
	/**
	 * Generates starter buttons
	 */
	private void generateStarters() {
		try {
			m_starters = new ToggleButton[12];
			for(int i = 0; i < m_starters.length; i++) {
				m_starters[i] = new ToggleButton();
				m_starters[i].setSize(32, 32);
				m_starters[i].setVisible(true);
			}
			m_starters[0].setImage(new Image("res/pokemon/icons/001.gif"));
			m_starters[0].setLocation(160, 24);
			m_starters[0].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					m_starter = 1;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[0]);
			
//			m_starters[1].setImage(new Image("res/pokemon/icons/004.gif"));
			m_starters[1].setImage(new Image("res/pokemon/icons/152.gif"));
			m_starters[1].setLocation(192, 24);
			m_starters[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 4;
					m_starter = 152;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[1]);
			
//			m_starters[2].setImage(new Image("res/pokemon/icons/007.gif"));
			m_starters[2].setImage(new Image("res/pokemon/icons/252.gif"));
			m_starters[2].setLocation(224, 24);
			m_starters[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 7;
					m_starter = 252;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[2]);
			
//			m_starters[3].setImage(new Image("res/pokemon/icons/152.gif"));
			m_starters[3].setImage(new Image("res/pokemon/icons/387.gif"));
			m_starters[3].setLocation(256, 24);
			m_starters[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 152;
					m_starter = 387;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[3]);
			
//			m_starters[4].setImage(new Image("res/pokemon/icons/155.gif"));
			m_starters[4].setImage(new Image("res/pokemon/icons/004.gif"));
			m_starters[4].setLocation(160, 56);
			m_starters[4].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 155;
					m_starter = 4;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[4]);
			
//			m_starters[5].setImage(new Image("res/pokemon/icons/158.gif"));
			m_starters[5].setImage(new Image("res/pokemon/icons/155.gif"));
			m_starters[5].setLocation(192, 56);
			m_starters[5].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 158;
					m_starter = 155;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[5]);
			
//			m_starters[6].setImage(new Image("res/pokemon/icons/252.gif"));
			m_starters[6].setImage(new Image("res/pokemon/icons/255.gif"));
			m_starters[6].setLocation(224, 56);
			m_starters[6].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 252;
					m_starter = 255;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[6]);
			
//			m_starters[7].setImage(new Image("res/pokemon/icons/255.gif"));
			m_starters[7].setImage(new Image("res/pokemon/icons/390.gif"));
			m_starters[7].setLocation(256, 56);
			m_starters[7].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 255;
					m_starter = 390;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[7]);
			
//			m_starters[8].setImage(new Image("res/pokemon/icons/258.gif"));
			m_starters[8].setImage(new Image("res/pokemon/icons/007.gif"));
			m_starters[8].setLocation(160, 88);
			m_starters[8].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 258;
					m_starter = 7;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[8]);
			
//			m_starters[9].setImage(new Image("res/pokemon/icons/387.gif"));
			m_starters[9].setImage(new Image("res/pokemon/icons/158.gif"));
			m_starters[9].setLocation(192, 88);
			m_starters[9].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 387;
					m_starter = 158;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[9]);
			
//			m_starters[10].setImage(new Image("res/pokemon/icons/390.gif"));
			m_starters[10].setImage(new Image("res/pokemon/icons/258.gif"));
			m_starters[10].setLocation(224, 88);
			m_starters[10].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					m_starter = 390;
					m_starter = 258;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[10]);
			
			m_starters[11].setImage(new Image("res/pokemon/icons/393.gif"));
			m_starters[11].setLocation(256, 88);
			m_starters[11].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					m_starter = 393;
					selectStarter(m_starter);
				}
			});
			this.add(m_starters[11]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Called when a starter is selected (disables the appropriate button)
	 * @param m_starter
	 */
	private void selectStarter(int m_starter) {
		for(int i = 0; i < m_starters.length; i++) {
			m_starters[i].setSelected(false);
		}
		switch(m_starter) {
		case 1:
			m_starters[0].setSelected(true);
			break;
		case 4:
			m_starters[4].setSelected(true);
			break;
		case 7:
			m_starters[8].setSelected(true);
			break;
		case 152:
			m_starters[1].setSelected(true);
			break;
		case 155:
			m_starters[5].setSelected(true);
			break;
		case 158:
			m_starters[9].setSelected(true);
			break;
		case 252:
			m_starters[2].setSelected(true);
			break;
		case 255:
			m_starters[6].setSelected(true);
			break;
		case 258:
			m_starters[10].setSelected(true);
			break;
		case 387:
			m_starters[3].setSelected(true);
			break;
		case 390:
			m_starters[7].setSelected(true);
			break;
		case 393:
			m_starters[11].setSelected(true);
			break;
		}
	}

	/**
	 * Registers the player
	 */
	private void register() {
		List<String> translated = Translator.translate("_LOGIN");
		if(m_username.getText() != null
				&& m_username.getText().length() >= 4 && m_username.getText().length() <= 12) {
			if(m_password.getText() != null & !m_password.getText().equalsIgnoreCase("")
					&& m_confirmPass.getText() != null && !m_confirmPass.getText().equalsIgnoreCase("") &&
					m_password.getText().compareTo(m_confirmPass.getText()) == 0) {
				if(m_email.getText() != null && this.isValidEmail(m_email.getText())
						&& m_confirmEmail.getText() != null && m_confirmEmail.getText().compareTo(m_email.getText()) == 0) {
					if(m_day.getText() != null && m_day.getText().length() > 0 && m_day.getText().length() < 3
							&& m_month.getText() != null && m_month.getText().length() > 0 && m_month.getText().length() < 3
							&& m_year.getText() != null && m_year.getText().length() == 4) {
						if(!m_terms.isEnabled()) {
							m_register.setEnabled(false);
							GameClient.getInstance().getLoadingScreen().setVisible(true);
							String bday = m_day.getText() + "/" + m_month.getText() + "/" + m_year.getText();
							GameClient.getInstance().getPacketGenerator().register(m_username.getText(),
									m_password.getText(), m_email.getText(), bday, m_starter, (m_gender == 0 ? 11: 20));
						} else {
							GameClient.messageDialog(translated.get(28), GameClient.getInstance().getDisplay());
						}
					} else {
						GameClient.messageDialog(translated.get(29), GameClient.getInstance().getDisplay());
					}
				} else {
					GameClient.messageDialog(translated.get(30), GameClient.getInstance().getDisplay());
				}
			} else {
				GameClient.messageDialog(translated.get(31), GameClient.getInstance().getDisplay());
			}
		} else {
			GameClient.messageDialog(translated.get(32), GameClient.getInstance().getDisplay());
		}
	}
	
	/**
	 * Cancels the registration
	 */
	private void cancel() {
		GameClient.getInstance().getLoginScreen().showLogin();
		m_register.setEnabled(true);
	}
	
	/**
	 * Enables the registration
	 */
	public void enableRegistration() {
		m_register.setEnabled(true);
	}
	
	/**
	 * Returns true if the email is a valid email address
	 * @param email
	 * @return
	 */
	private boolean isValidEmail(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(email).matches())
                return true;
        else
                return false;
	}
	
	/**
	 * Tabs to the next field. 
	 * @param email
	 * @return
	 */
	public void goToNext() {
		if (m_username.hasFocus()) {
			m_username.releaseFocus();
			m_password.grabFocus();
		} else if (m_password.hasFocus()) {
			m_password.releaseFocus();
			m_confirmPass.grabFocus();
		} else if (m_confirmPass.hasFocus()) {
			m_confirmPass.releaseFocus();
			m_day.grabFocus();
		} else if (m_day.hasFocus()) {
			m_day.releaseFocus();
			m_month.grabFocus();
		} else if (m_month.hasFocus()) {
			m_month.releaseFocus();
			m_year.grabFocus();
		} else if (m_year.hasFocus()) {
			m_year.releaseFocus();
			m_email.grabFocus();
		} else if (m_email.hasFocus()) {
			m_email.releaseFocus();
			m_confirmEmail.grabFocus();
		}else if (m_confirmEmail.hasFocus()) {
			m_confirmEmail.releaseFocus();
			m_username.grabFocus();
		}else{
			m_username.grabFocus();
		}
	}
	
	public void reloadStrings(){
		List<String> translated = Translator.translate("_LOGIN");
		this.setTitle(translated.get(9));
		m_u.setText(translated.get(5));
		m_p.setText(translated.get(6));
		m_cp.setText(translated.get(10));
		m_d.setText(translated.get(11));
		m_e.setText(translated.get(12));
		m_ce.setText(translated.get(13));
		m_s.setText(translated.get(14));
		m_g.setText(translated.get(15));
		m_male.setText(translated.get(16));
		m_female.setText(translated.get(17));
		m_tos.setText(translated.get(18));
		m_terms.setText(translated.get(19));
		m_register.setText(translated.get(8));
		m_cancel.setText(translated.get(20));
	}
}