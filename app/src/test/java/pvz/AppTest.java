// package pvz;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import pvz.pack.Inventory;
// import pvz.plantfactory.PlantFactory;
// import java.util.Set;
// import static org.junit.jupiter.api.Assertions.*;

// class AppTest {
//     private Inventory inventory;

//     @BeforeEach
//     void setUp() {
//         inventory = new Inventory();
//     }

//     @Test
//     void testGetInventory() {
//         Set<PlantFactory> result = inventory.getInventory();
//         assertNotNull(result);
//         assertEquals(2, result.size()); // Update the expected size based on the number of PlantFactory classes in the package
//     }

//     @Test
//     void testSwapInventory() {
//         // Test swapping valid positions
//         inventory.swapInventory(1, 2);
//         // Add assertions to verify the expected changes in the inventory

//         // Test swapping invalid positions
//         assertThrows(IllegalArgumentException.class, () -> inventory.swapInventory(0, 5));
//         // Add assertions to verify the expected exception
//     }

//     // Add more test methods as needed
// }