package mainmodule;

import operation.MagicOfBooks;
import userbookinf.Adminop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MagicOfBooks mob = new MagicOfBooks();
        while (true){
            System.out.println("**********Login Menu***********");
            System.out.println("1. Login as a User");
            System.out.println("2. Register as a User");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    try {
                        mob.login();
                        System.out.println("***********Main Menu***********");
                        System.out.println("1. Add Books");
                        System.out.println("2. Display Books");
                        System.out.println("3. Check Book");
                        System.out.println("4. Book Details");
                        System.out.println("5. Exit");
                        System.out.println("Enter your choice:");
                        int m = sc.nextInt();
                        switch (m) {
                            case 1:
                                try {
                                    System.out.println("**********Add Books**********");
                                    System.out.println("1. Add New Books");
                                    System.out.println("2. Add Favourite Books");
                                    System.out.println("3. Add Completed Books");
                                    System.out.println("4. Exit");
                                    System.out.println("Enter your choice:");
                                    int m2 = sc.nextInt();
                                    switch (m2) {
                                        case 1:
                                            try {
                                                mob.addnewbook();
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 2:
                                            try {
                                                mob.addfavoritebook();
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 3:
                                            try {
                                                mob.addcompletedbooks();
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    mob.displaybooks();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    mob.chkavailability();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                try {
                                    mob.displaybkdetails();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        mob.registration();
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                	Adminop ad = new Adminop();
                	int op = 1;
                	while(op==1) {
                		int val = ad.displayMenu();
                		ad.operation(val);
                		sc.nextLine();
                		System.out.println("Do you want to continue?");
                		String s = sc.nextLine();
                		if(s.equalsIgnoreCase("yes")) {
                			op=1;
                		}else {
                			op=0;
                			System.out.println("Press 1 from Main Menu and 0 For Exit!");
                			int num = sc.nextInt();
                			if(num==0) {
                				System.exit(num);
                			}
                			else {
                				op=1;
                			}
                		}
                	}
                	break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
                    }
        }
    }
}
