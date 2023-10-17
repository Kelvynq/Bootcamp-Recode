import java.util.Scanner;
import java.sql.Date;

import reserva.Reserva;
import reserva.ReservaDAO;
import usuario.Usuario;
import usuario.UsuarioDAO;
import viagem.Viagem;
import viagem.ViagemDAO;

public class Main2 {

	    @SuppressWarnings("deprecation")
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int escolha;
	        
	        	//MENU PRINCIPAL
	    		do {
	    			System.out.println("===== Menu Principal =====");;
	    			System.out.println("=      1 - CRIAR         =");
	    			System.out.println("=      2 - VISUALIZAR    =");
	    			System.out.println("=      3 - EDITAR        =");
	    			System.out.println("=      4 - EXCLUIR       =");
	    			System.out.println("=      5 - SAIR          =");
	    			System.out.println("==========================");
	    			System.out.print("Escolha uma opção: ");
	    			escolha = scanner.nextInt();
	            
	            switch (escolha) {
	                case 1:
	                    System.out.println("Você escolheu a opção CRIAR");
	                    break;
	                case 2:
	                    System.out.println("Você escolheu a opção VISUALIZAR");
	                    break;
	                case 3:
	                    System.out.println("Você escolheu a opção EDITAR");
	                    break;
	                case 4:
	                    System.out.println("Você escolheu a opção EXCLUIR");
	                    break;
	                case 5:
	                    System.out.println("Saindo do programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	            
	            // SubMenu Criar
	            if (escolha == 1) {
	                int escolhaSubmenu;
	                do {
	                	System.out.println("=========== Menu Criar ==============");;
						System.out.println("=    1 - Cria usuário               =");
						System.out.println("=    2 - Criar viagem               =");
						System.out.println("=    3 - Criar reserva              =");
						System.out.println("=    4 - Voltar ao Menu Principal   =");
						System.out.println("=====================================");
						System.out.print("Escolha uma opção: ");
						escolhaSubmenu = scanner.nextInt();
	                    	                    
	                    switch (escolhaSubmenu) {
	                        case 1:
	                        	scanner.nextLine();
								Usuario usuario = new Usuario();
								UsuarioDAO usuarioDAO = new UsuarioDAO();
								System.out.println("Nome Completo: ");
								usuario.setNOME_U(scanner.nextLine());
								System.out.println("EMAIL: ");
								usuario.setEMAIL_U(scanner.nextLine());
								System.out.println("Senha: ");
								usuario.setSENHA_U(scanner.nextLine());
								usuarioDAO.criarUsuario(usuario);
								break;
	                        case 2:
	                        	scanner.nextLine();
								Viagem viagem = new Viagem();
								UsuarioDAO usuarioDAO2 = new UsuarioDAO();
								ViagemDAO viagemDAO = new ViagemDAO();
								System.out.println("Estado: ");
								viagem.setESTADO_V(scanner.nextLine());
								System.out.println("Cidade: ");
								viagem.setCIDADE_V(scanner.nextLine());
								System.out.println("ID do usuário: ");
								int usuarioId = scanner.nextInt();
								Usuario usuariob = usuarioDAO2.buscarUsuario(usuarioId);
								if (usuariob != null) {
									viagem.setUsuario(usuariob);
								} else {
									System.out.println("Usuário não encontrado.");
								}
								viagemDAO.criarViagem(viagem);
								break;
	                        case 3:
	                        	scanner.nextLine();
								Reserva reserva = new Reserva();
								ReservaDAO reservaDAO = new ReservaDAO();
								UsuarioDAO usuarioDAO3 = new UsuarioDAO();
								ViagemDAO viagemDAO2 = new ViagemDAO();
								System.out.println("Valor: ");
								reserva.setVALOR(scanner.nextFloat());
								System.out.println("Dia do check-in: ");
								int diai = scanner.nextInt();
								System.out.println("Mês do check-in: ");
								int mesi = scanner.nextInt();
								System.out.println("Ano do check-in: ");
								int anoi = scanner.nextInt();
								reserva.setDATA_INICIO(new Date(anoi-1900, mesi-1, diai));
								System.out.println("Dia do check-out: ");
								int diaf = scanner.nextInt();
								System.out.println("Mês do check-out: ");
								int mesf = scanner.nextInt();
								System.out.println("Ano do check-out: ");
								int anof = scanner.nextInt();
								reserva.setDATA_FIM(new Date(anof-1900, mesf-1, diaf));
								System.out.println("ID do usuário: ");
								int usuarioIdr = scanner.nextInt();
								Usuario usuariobr = usuarioDAO3.buscarUsuario(usuarioIdr);
								if (usuariobr != null) {
									reserva.setUsuario(usuariobr);
								} else {
									System.out.println("Usuário não encontrado.");
								}
								System.out.println("ID da viagem: ");
								int viagemId = scanner.nextInt();
								Viagem viagemb = viagemDAO2.buscarViagem(viagemId);
								if (viagemb != null) {
									reserva.setViagem(viagemb);
								} else {
									System.out.println("Viagem não encontrado.");
								}
								reservaDAO.criarReserva(reserva);
	                            break;
	                        case 4:
	                            System.out.println("Voltando ao Menu Principal.");
	                            break;
	                        default:
	                            System.out.println("Opção inválida. Tente novamente.");
	                            break;
	                    }
	                } while (escolhaSubmenu != 4); // Continue no submenu até o usuário escolher "Voltar ao Menu Principal"
	            }
	            
	         // Submenu Visualizar
	            if (escolha == 2) {
						int escolhaSubmenuv;
						do {
							System.out.println("========== Menu Visualizar ==========");;
							System.out.println("=     1 - Visualizar usuário        =");
							System.out.println("=     2 - Visualizar viagem         =");
							System.out.println("=     3 - Visualizar reserva        =");
							System.out.println("=     4 - Voltar ao Menu Principal  =");
							System.out.println("=====================================");
							System.out.print("Escolha uma opção: ");
							escolhaSubmenuv = scanner.nextInt();

							switch (escolhaSubmenuv) {
							case 1:
								UsuarioDAO usuarioDAO = new UsuarioDAO();
								usuarioDAO.lerTodosUsuarios();
								break;
							case 2:
								ViagemDAO viagemDAO = new ViagemDAO();
								viagemDAO.lerTodasViagens();
								break;
							case 3:
								ReservaDAO reservaDAO = new ReservaDAO();
								reservaDAO.lerTodasReservas();
								break;
							case 4:
								System.out.println("Voltando ao Menu Principal.");
								break;
							default:
								System.out.println("Opção inválida. Tente novamente.");
								break;
							}
						} while (escolhaSubmenuv != 4);
						//FIM DO SUBMENU VISUALIZAR
	            }
	            if (escolha == 3) {
					int escolhaSubmenue;
					do {
						System.out.println("=========== Menu Editar =============");;
						System.out.println("=     1 - Editar usuário            =");
						System.out.println("=     2 - Editar viagem             =");
						System.out.println("=     3 - Editar reserva            =");
						System.out.println("=     4 - Voltar ao Menu Principal  =");
						System.out.println("=====================================");
						System.out.print("Escolha uma opção: ");
						escolhaSubmenue = scanner.nextInt();

						switch (escolhaSubmenue) {
						case 1:
							scanner.nextLine();
							Usuario usuario = new Usuario();
							UsuarioDAO usuarioDAO = new UsuarioDAO();
							System.out.println("Nome Completo: ");
							usuario.setNOME_U(scanner.nextLine());
							System.out.println("EMAIL: ");
							usuario.setEMAIL_U(scanner.nextLine());
							System.out.println("Senha: ");
							usuario.setSENHA_U(scanner.nextLine());
							System.out.println("ID Usuário:");
							usuario.setID_USUARIO(scanner.nextInt());
							usuarioDAO.atualizarUsuario(usuario);
							break;
						case 2:
							scanner.nextLine();
							Viagem viagem = new Viagem();
							UsuarioDAO usuarioDAO2 = new UsuarioDAO();
							ViagemDAO viagemDAO = new ViagemDAO();
							System.out.println("Estado: ");
							viagem.setESTADO_V(scanner.nextLine());
							System.out.println("Cidade: ");
							viagem.setCIDADE_V(scanner.nextLine());
							System.out.println("ID do usuário: ");
							int usuarioId = scanner.nextInt();
							Usuario usuariob = usuarioDAO2.buscarUsuario(usuarioId);
							if (usuariob != null) {
								viagem.setUsuario(usuariob);
							} else {
								System.out.println("Usuário não encontrado.");
							}
							System.out.println("ID VIAGEM:");
							viagem.setID_VIAGEM(scanner.nextInt());
							viagemDAO.atualizarViagem(viagem);
							break;
						case 3:
							scanner.nextLine();
							Reserva reserva = new Reserva();
							ReservaDAO reservaDAO = new ReservaDAO();
							UsuarioDAO usuarioDAO3 = new UsuarioDAO();
							ViagemDAO viagemDAO2 = new ViagemDAO();
							System.out.println("Valor: ");
							reserva.setVALOR(scanner.nextFloat());
							System.out.println("Dia do check-in: ");
							int diai = scanner.nextInt();
							System.out.println("Mês do check-in: ");
							int mesi = scanner.nextInt();
							System.out.println("Ano do check-in: ");
							int anoi = scanner.nextInt();
							reserva.setDATA_INICIO(new Date(anoi-1900, mesi-1, diai));
							System.out.println("Dia do check-out: ");
							int diaf = scanner.nextInt();
							System.out.println("Mês do check-out: ");
							int mesf = scanner.nextInt();
							System.out.println("Ano do check-out: ");
							int anof = scanner.nextInt();
							reserva.setDATA_FIM(new Date(anof-1900, mesf-1, diaf));
							System.out.println("ID do usuário: ");
							int usuarioIdr = scanner.nextInt();
							Usuario usuariobr = usuarioDAO3.buscarUsuario(usuarioIdr);
							if (usuariobr != null) {
								reserva.setUsuario(usuariobr);
							} else {
								System.out.println("Usuário não encontrado.");
							}
							System.out.println("ID da viagem: ");
							int viagemId = scanner.nextInt();
							Viagem viagemb = viagemDAO2.buscarViagem(viagemId);
							if (viagemb != null) {
								reserva.setViagem(viagemb);
							} else {
								System.out.println("Viagem não encontrada.");
							}
							System.out.println("ID reserva:");
							reserva.setID_RESERVA(scanner.nextInt());
							reservaDAO.atualizarReserva(reserva);
						case 4:
							System.out.println("Voltando ao Menu Principal.");
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (escolhaSubmenue != 4); // FIM DO SUBMENU EDITAR 
				}
	            
	         // Submenu Deletar
				if (escolha == 4) {
					int escolhaSubmenuD;
					do {
						System.out.println("========= Menu Deletar ==============");;
						System.out.println("=     1 - Deletar usuário           =");
						System.out.println("=     2 - Deletar viagem            =");
						System.out.println("=     3 - Deletar reserva           =");
						System.out.println("=     4 - Voltar ao Menu Principal  =");
						System.out.println("=====================================");
						System.out.print("Escolha uma opção: ");
						escolhaSubmenuD = scanner.nextInt();

						switch (escolhaSubmenuD) {
						case 1:
							UsuarioDAO usuarioDAO = new UsuarioDAO();
							System.out.println("Digite o ID do Usuário a ser DELETADO");
							int idusuario = scanner.nextInt();
							usuarioDAO.deleteUsuario(idusuario);
							break;
						case 2:
							ViagemDAO viagemDAO = new ViagemDAO();
							System.out.println("Digite o ID da Viagem a ser DELETADO");
							int idviagem = scanner.nextInt();
							viagemDAO.deleteViagem(idviagem);
							break;
						case 3:
							ReservaDAO reservaDAO = new ReservaDAO();
							System.out.println("Digite o ID da Reserva a ser DELETADO");
							int idreserva = scanner.nextInt();
							reservaDAO.deleteReserva(idreserva);
							break;
						case 4:
							System.out.println("Voltando ao Menu Principal.");
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (escolhaSubmenuD != 4); //FIM DO SUBMENU EXCLUIR
				}
				
	        } while (escolha != 5); // Continue no menu principal até o usuário escolher "Sair"
	        
	        scanner.close();
	
}
}

