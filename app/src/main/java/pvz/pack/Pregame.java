package pvz.pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pregame extends JFrame {
    private Inventory inventory;
    private Deck deck;

    public Pregame() {
        PregameMediator mediator = new PregameMaster();

        inventory = new Inventory(mediator);
        deck = new Deck(mediator);

        mediator.registerInventory(inventory);
        mediator.registerDeck(deck);

        // Create the GUI components
        JLabel inventoryLabel = new JLabel("Inventory: " + inventory.getInfo());
        JLabel deckLabel = new JLabel("Deck: " + deck.getInfo());

        JButton addToDeckButton = new JButton("Add to deck");
        JButton removeFromDeckButton = new JButton("Remove from deck");
        JButton swapInventoryButton = new JButton("Swap inventory");
        JButton swapDeckButton = new JButton("Swap deck");

        // Set the layout
        setLayout(new GridLayout(6, 1));

        // Add the components to the frame
        add(inventoryLabel);
        add(deckLabel);
        add(addToDeckButton);
        add(removeFromDeckButton);
        add(swapInventoryButton);
        add(swapDeckButton);

        // Add action listeners to the buttons
        addToDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter the position of PlantFactory in the inventory to add to deck:");
                int position = Integer.parseInt(input);
                inventory.addToDeck(position);
                inventoryLabel.setText("Inventory: " + inventory.getInfo());
                deckLabel.setText("Deck: " + deck.getInfo());
            }
        });

        removeFromDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter the position of PlantFactory in the deck to remove:");
                int position = Integer.parseInt(input);
                inventory.removeFromDeck(position);
                inventoryLabel.setText("Inventory: " + inventory.getInfo());
                deckLabel.setText("Deck: " + deck.getInfo());
            }
        });

        swapInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = JOptionPane.showInputDialog("Enter the position of PlantFactory in the inventory to swap:");
                int pos1 = Integer.parseInt(input1);
                String input2 = JOptionPane.showInputDialog("Enter the position of PlantFactory in the inventory to swap with:");
                int pos2 = Integer.parseInt(input2);
                inventory.swap(pos1, pos2);
                inventoryLabel.setText("Inventory: " + inventory.getInfo());
                deckLabel.setText("Deck: " + deck.getInfo());
            }
        });

        swapDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = JOptionPane.showInputDialog("Enter the position of PlantFactory in the deck to swap:");
                int pos1 = Integer.parseInt(input1);
                String input2 = JOptionPane.showInputDialog("Enter the position of PlantFactory in the deck to swap with:");
                int pos2 = Integer.parseInt(input2);
                deck.swap(pos1, pos2);
                inventoryLabel.setText("Inventory: " + inventory.getInfo());
                deckLabel.setText("Deck: " + deck.getInfo());
            }
        });

        // Set frame properties
        setTitle("Pregame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pregame();
            }
        });
    }
}
