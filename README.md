# SariTrack

**Java Foundations Final Project**

Submitted by: [Names of group members]

SariTrack is a console-based Java application, a Sari-Sari Store Inventory System, that helps a small neighborhood store owner manage products and sales. The owner can view the inventory, add new products, sell items, restock items that are running low, and check the total sales earned. The program automatically warns the user when a product's stock is low.

## Features

- View the inventory with **[LOW STOCK!]** alerts
- Add a new product
- Sell a product (stock is checked before the sale)
- Restock a product
- View total sales
- Input validation: the program does not crash on wrong input

## Classes

| Class | Fields | Methods |
|---|---|---|
| `Product` | `name`, `price`, `stock` | `sell()`, `restock()`, `isLowStock()` |
| `Store` | `storeName`, `products` (ArrayList), `totalSales` | `addProduct()`, `showInventory()`, `findProduct()`, `sellProduct()` |
| `Main` | Test class and menu | Handles user input and calls the other classes |

## How to Run

1. Install JDK 17 or later.
2. Clone or download this repository.
3. Open the folder in VS Code and run `src/Main.java`.

Or using the terminal:

```
cd src
javac *.java
java Main
```

## Project Structure

```
SARIPROJECT/
├── docs/
│   └── SariTrack.docx
├── src/
│   ├── Main.java
│   ├── Product.java
│   └── Store.java
└── README.md
```

## Technologies

- Java (JDK 17 or later)
- Visual Studio Code