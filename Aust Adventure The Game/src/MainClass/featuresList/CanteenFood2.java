package MainClass.featuresList;

import MainClass.GamePanel;
import MainClass.Player;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class CanteenFood2 extends JPanel {

    private String answer;
    private JFrame frame;
    private JPanel panel;
    private JLabel BG, dialog, AvaialabeList, SelectedItem, coinAvailabe;
    private JLabel item1, item2, item3, item4, item5, priceUpdivider, totalSelected;
    private JButton BuyButton, BackButton, addButton1, addButton2, addButton3, addButton4, addButton5, removeButton1,
            removeButton2, removeButton3, removeButton4, removeButton5, showPrice;
    private JLabel coffeeImage, pizzaImage, birianImage, noodlesImage, burgerIamge;
    private ButtonGroup group;

    private int coffieCounter = 0, pizzaCounter = 0, birianiCounter = 0, noodlesCounter = 0, burgerCounter = 0, totalCounter = 0;
    private boolean itemselection = false;

    private final int burger = 25, pizza = 28, biriani = 55, noodles = 15, coffee = 8;
    private Color panelColor, buttonColor;
    Player player;
    Image imageSelect;
    static int correctAnsCount = 0;

    public CanteenFood2() {

        frame = new JFrame("Hingry! Buy Food");

        panel = new JPanel();

        panelColor = new Color(255, 205, 65);

        buttonColor = new Color(255, 255, 255);

        addButton1 = new JButton();

        BG = new JLabel();
        BG.setIcon(new ImageIcon("resources\\images\\background\\canteenBG.png"));
        BG.setBounds(0, 0, 1280, 720);

        addButton1.setIcon(new ImageIcon("resources\\images\\others\\plus_quantity.png"));
        addButton1.setBounds(50, 265, 50, 50);
        addButton1.setOpaque(false);
        addButton1.setContentAreaFilled(false);
        addButton1.setBorderPainted(false);
        addButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (coffieCounter == 5) {
                    coffieCounter = 5;
                } else {
                    coffieCounter++;
                    itemselection = true;
                }
            }
        });

        addButton2 = new JButton();
        addButton2.setBackground(buttonColor);
        addButton2.setIcon(new ImageIcon("resources\\images\\others\\plus_quantity.png"));
        addButton2.setBounds(280, 265, 50, 50);
        addButton2.setOpaque(false);
        addButton2.setContentAreaFilled(false);
        addButton2.setBorderPainted(false);
        addButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (pizzaCounter == 5) {
                    pizzaCounter = 5;
                } else {
                    pizzaCounter++;
                    itemselection = true;
                }
            }
        });

        addButton3 = new JButton();
        addButton3.setBackground(buttonColor);
        addButton3.setIcon(new ImageIcon("resources\\images\\others\\plus_quantity.png"));
        addButton3.setBounds(510, 265, 50, 50);
        addButton3.setOpaque(false);
        addButton3.setContentAreaFilled(false);
        addButton3.setBorderPainted(false);
        addButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (birianiCounter == 5) {
                    birianiCounter = 5;
                } else {
                    birianiCounter++;
                    itemselection = true;
                }
            }
        });

        addButton4 = new JButton();
        addButton4.setBackground(buttonColor);
        addButton4.setIcon(new ImageIcon("resources\\images\\others\\plus_quantity.png"));
        addButton4.setBounds(740, 265, 50, 50);
        addButton4.setOpaque(false);
        addButton4.setContentAreaFilled(false);
        addButton4.setBorderPainted(false);
        addButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (noodlesCounter == 5) {
                    noodlesCounter = 5;
                } else {
                    noodlesCounter++;
                    itemselection = true;
                }
            }
        });

        addButton5 = new JButton();
        addButton5.setBackground(buttonColor);
        addButton5.setIcon(new ImageIcon("resources\\images\\others\\plus_quantity.png"));
        addButton5.setBounds(975, 265, 50, 50);
        addButton5.setOpaque(false);
        addButton5.setContentAreaFilled(false);
        addButton5.setBorderPainted(false);
        addButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (burgerCounter == 5) {
                    burgerCounter = 5;
                } else {
                    burgerCounter++;
                    itemselection = true;
                }

            }
        });

        removeButton1 = new JButton();
        removeButton1.setBackground(buttonColor);
        removeButton1.setIcon(new ImageIcon("resources\\images\\others\\minus_quantity.png"));
        removeButton1.setBounds(210, 265, 50, 50);
        removeButton1.setOpaque(false);
        removeButton1.setContentAreaFilled(false);
        removeButton1.setBorderPainted(false);
        removeButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (coffieCounter == 0) {
                    coffieCounter = 0;
                } else {
                    coffieCounter--;
                }
            }
        });

        removeButton2 = new JButton();
        removeButton2.setBackground(buttonColor);
        removeButton2.setIcon(new ImageIcon("resources\\images\\others\\minus_quantity.png"));
        removeButton2.setBounds(440, 265, 50, 50);
        removeButton2.setOpaque(false);
        removeButton2.setContentAreaFilled(false);
        removeButton2.setBorderPainted(false);
        removeButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (pizzaCounter == 0) {
                    pizzaCounter = 0;
                } else {
                    pizzaCounter--;
                }
            }
        });

        removeButton3 = new JButton();
        removeButton3.setBackground(buttonColor);
        removeButton3.setIcon(new ImageIcon("resources\\images\\others\\minus_quantity.png"));
        removeButton3.setBounds(670, 265, 50, 50);
        removeButton3.setOpaque(false);
        removeButton3.setContentAreaFilled(false);
        removeButton3.setBorderPainted(false);
        removeButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (birianiCounter == 0) {
                    birianiCounter = 0;
                } else {
                    birianiCounter--;
                }
            }
        });

        removeButton4 = new JButton();
        removeButton4.setBackground(buttonColor);
        removeButton4.setIcon(new ImageIcon("resources\\images\\others\\minus_quantity.png"));
        removeButton4.setBounds(900, 265, 50, 50);
        removeButton4.setOpaque(false);
        removeButton4.setContentAreaFilled(false);
        removeButton4.setBorderPainted(false);
        removeButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (noodlesCounter == 0) {
                    noodlesCounter = 0;
                } else {
                    noodlesCounter--;
                }

            }
        });

        removeButton5 = new JButton();
        removeButton5.setBackground(buttonColor);
        removeButton5.setIcon(new ImageIcon("resources\\images\\others\\minus_quantity.png"));
        removeButton5.setBounds(1130, 265, 50, 50);
        removeButton5.setOpaque(false);
        removeButton5.setContentAreaFilled(false);
        removeButton5.setBorderPainted(false);
        removeButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (burgerCounter == 0) {
                    burgerCounter = 0;
                } else {
                    burgerCounter--;
                }

            }
        });

        coffeeImage = new JLabel();
        coffeeImage.setIcon(new ImageIcon("resources\\images\\canteenFoods\\coffee1.jpg"));
        coffeeImage.setBounds(80, 120, 158, 180);
        panel.add(coffeeImage);

        pizzaImage = new JLabel();
        pizzaImage.setIcon(new ImageIcon("resources\\images\\canteenFoods\\pizza1.png"));
        pizzaImage.setBounds(310, 120, 158, 180);
        panel.add(pizzaImage);

        birianImage = new JLabel();
        birianImage.setIcon(new ImageIcon("resources\\images\\canteenFoods\\biriani1.png"));
        birianImage.setBounds(540, 120, 158, 180);
        panel.add(birianImage);

        noodlesImage = new JLabel();
        noodlesImage.setIcon(new ImageIcon("resources\\images\\canteenFoods\\noodles.jpg"));
        noodlesImage.setBounds(770, 120, 158, 180);
        panel.add(noodlesImage);

        burgerIamge = new JLabel();
        burgerIamge.setIcon(new ImageIcon("resources\\images\\canteenFoods\\burger1.png"));
        burgerIamge.setBounds(1000, 120, 158, 180);
        panel.add(burgerIamge);

        BuyButton = new JButton();
        BuyButton.setBackground(buttonColor);
        BuyButton.setBounds(800, 600, 155, 55);
        BuyButton.setIcon(new ImageIcon("resources\\images\\others\\buy1.png"));
        BuyButton.addActionListener(new OKListener());
        BuyButton.setOpaque(false);
        BuyButton.setContentAreaFilled(false);
        BuyButton.setBorderPainted(false);

        BackButton = new JButton();
        BackButton.setBackground(buttonColor);
        BackButton.setBounds(1000, 600, 155, 55);
        BackButton.setIcon(new ImageIcon("resources\\images\\others\\back1.png"));
        BackButton.addActionListener(new CancelListener());
        BackButton.setOpaque(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setBorderPainted(false);

        showPrice = new JButton();
        showPrice.setBackground(buttonColor);
        showPrice.setBounds(590, 600, 180, 55);
        showPrice.setIcon(new ImageIcon("resources\\images\\others\\show.png"));
        showPrice.addActionListener(new showListener());
        showPrice.setOpaque(false);
        showPrice.setContentAreaFilled(false);
        showPrice.setBorderPainted(false);

        AvaialabeList = new JLabel();
        SelectedItem = new JLabel();
        coinAvailabe = new JLabel();

        item1 = new JLabel();
        item2 = new JLabel();
        item3 = new JLabel();
        item4 = new JLabel();
        item5 = new JLabel();

        totalSelected = new JLabel();
        priceUpdivider = new JLabel();

        //coinAvailabe2 = new JLabel();
        //dialog = new JLabel(Question[ChoiceIndex]);
        frame.setSize(1280, 720);

        frame.setResizable(false);

        panel.setLayout(null);
        panel.setBackground(panelColor);

        Font font1 = new Font("SansSerif", Font.BOLD, 25);

        item1.setBounds(80, 300, 240, 180);
        item1.setFont(font1);
        item1.setText("");

        item2.setBounds(80, 350, 240, 180);
        item2.setFont(font1);

        item3.setBounds(80, 400, 240, 180);
        item3.setFont(font1);

        item4.setBounds(80, 450, 240, 180);
        item4.setFont(font1);

        item5.setBounds(80, 500, 240, 180);
        item5.setFont(font1);

        priceUpdivider.setBounds(70, 525, 280, 180);
        priceUpdivider.setFont(font1);

        totalSelected.setBounds(80, 550, 300, 180);
        totalSelected.setFont(font1);

        coinAvailabe.setBounds(500, 0, 500, 100);
        coinAvailabe.setAutoscrolls(true);
        coinAvailabe.setFont(font1);
        coinAvailabe.setText(" Coin Available: " + GamePanel.point);
        panel.add(coinAvailabe);

        AvaialabeList.setBounds(40, 40, 700, 100);
        AvaialabeList.setFont(font1);
        AvaialabeList.setText("#.Items Available In The List Are: ");
        panel.add(AvaialabeList);

        SelectedItem.setBounds(40, 300, 300, 100);
        SelectedItem.setFont(font1);
        SelectedItem.setText("#.Item Selected: ");
        panel.add(SelectedItem);

        panel.add(BuyButton);

        panel.add(BackButton);

        panel.add(showPrice);
        panel.add(priceUpdivider);
        panel.add(totalSelected);
        panel.add(item1);
        panel.add(item2);
        panel.add(item3);
        panel.add(item4);
        panel.add(item5);
        panel.add(addButton1);
        panel.add(addButton2);
        panel.add(addButton3);
        panel.add(addButton4);
        panel.add(addButton5);
        panel.add(removeButton1);
        panel.add(removeButton2);
        panel.add(removeButton3);
        panel.add(removeButton4);
        panel.add(removeButton5);
        panel.add(pizzaImage);
        panel.add(coffeeImage);
        panel.add(burgerIamge);
        panel.add(noodlesImage);
        panel.add(birianImage);
        group = new ButtonGroup();

        group.add(BuyButton);
        group.add(BackButton);
        panel.add(BG);
        //Selection

        /*
        coffeeImage.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
           if (GamePanel.point>=coffee) {
                   answer = "a";
                  //  item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\coffee1.jpg"));
                   // JOptionPane.showMessageDialog(null,"Item Selected");
               }else if (GamePanel.point!=coffee) {
                   JOptionPane.showMessageDialog(null,"You Don't Have enough coin to buy it. please collect coin");
               }
         }
     });
        
        pizzaImage.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
            if (GamePanel.point>=pizza) {
                   answer = "b";
                  //  item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\pizza1.png"));
                   // JOptionPane.showMessageDialog(null,"Item Selected");
               }else if (GamePanel.point!=pizza) {
                   JOptionPane.showMessageDialog(null,"You Don't Have enough coin to buy it. please collect coin");
               }
         }
     });
        
        birianImage.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
              if (GamePanel.point>=pizza) {
                   answer = "c";
                    //item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\biriani1.png"));
         
               }else if (GamePanel.point!=pizza) {
                   JOptionPane.showMessageDialog(null,"You Don't Have enough coin to buy it. please collect coin");
               }
         }
     });
        
        noodlesImage.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
           if (GamePanel.point>=noodles) {
                   answer = "d";
                  //  item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\noodles.jpg"));
              
               }else if (GamePanel.point!=noodles) {
                   JOptionPane.showMessageDialog(null,"You Don't Have enough coin to buy it. please collect coin");
               }
         }
     });
        
        burgerIamge.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
            if (GamePanel.point>=burger) {
                    answer = "e";
                    //item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\burger1.png"));
      
               }else if (GamePanel.point!=burger) {
                   JOptionPane.showMessageDialog(null,"You Don't Have enough coin to buy it. please collect coin");
               }
         }
     });
         */
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        // frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        //frame.setContentPane(new JLabel(new ImageIcon("resources\\images\\others\\bge.png")));

    }

    private class showListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (itemselection == false) {
                JOptionPane.showMessageDialog(null,
                        "Select An Item First",
                        "Warning!!!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                item1.setText("Coffee :           " + coffieCounter + " x " + coffee + "");
                item2.setText("Pizza:           " + pizzaCounter + " x " + pizza + "");
                item3.setText("Biriani:           " + birianiCounter + " x " + biriani + "");
                item4.setText("Noodles:         " + noodlesCounter + " x " + noodles + "");
                item5.setText("Burger:           " + burgerCounter + " x " + burger + "");
                totalCounter = (coffieCounter * coffee) + (pizzaCounter * pizza)
                        + (birianiCounter * biriani) + (noodlesCounter * noodles) + (burgerCounter * burger);
                priceUpdivider.setText("----------------------------------");
                totalSelected.setText("Total Price:    " + totalCounter);
                System.out.println("Hello");
            }
        }
    }

    private class OKListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (totalCounter>GamePanel.point) {
                JOptionPane.showMessageDialog(null, "You dont have enough budget! ");
            }else{
            GamePanel.point -= totalCounter;
            if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy += (float) (totalCounter*2.5);
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }
                    }
            }
                /*
            //Do function if OK Button is pressed
            if (answer != null) {
                //Do action if an answer is pressed
                if (answer.equals("a")) {
                    //Do action if answer is correct
                    GamePanel.point -= 10;

                    //item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\blank.png"));
                    //energy will be loose
                    if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy += 25;
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }
                    }
                    //frame.setVisible(false);
                } else if (answer.equals("b")) {
                    //Do action if answer is correct
                    GamePanel.point -= 30;

                    JOptionPane.showMessageDialog(null, "Done.");
                    //  item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\blank.png"));
                    if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy = player.energy + 40;
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }

                    }
                    //frame.setVisible(false);
                } else if (answer.equals("c")) {
                    //Do action if answer is correct
                    GamePanel.point -= 85;

                    JOptionPane.showMessageDialog(null, "Done.");
                    // item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\blank.png"));
                    //energy will be loose
                    if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy = player.energy + 50;
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }

                    }
                    //frame.setVisible(false);
                } else if (answer.equals("d")) {
                    //Do action if answer is correct
                    GamePanel.point -= 25;

                    JOptionPane.showMessageDialog(null, "Done.");
                    //   item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\blank.png"));
                    //energy will be loose
                    if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy = player.energy + 30;
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }

                    }

                    //frame.setVisible(false);
                } else if (answer.equals("e")) {
                    //Do action if answer is correct'
                    GamePanel.point -= 30;

                    JOptionPane.showMessageDialog(null, "Done.");
                    //    item.setIcon(new ImageIcon("resources\\images\\canteenFoods\\blank.png"));
                    //energy will be loose
                    if (player.energy != 100) {
                        if (player.energy < 100) {
                            player.energy = player.energy + 40;
                        }
                        if (player.energy >= 100) {
                            player.energy = 100;
                        }

                    }
                    // frame.setVisible(false);
                }

            } else {
                //Do action if no answer is pressed
                JOptionPane.showMessageDialog(null, "You have'nt select anything! ");
                frame.setVisible(false);
            }
            */ 
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            itemselection = false;
            pizzaCounter = 0;
            burgerCounter = 0;
            coffieCounter = 0;
            birianiCounter = 0;
            noodlesCounter = 0;
            GamePanel.time2.start();
            frame.setVisible(false);
        }
    }

}
