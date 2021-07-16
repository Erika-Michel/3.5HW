package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Product first = new Book(1, "Summer", 155, "Abc");
    private Product second = new Book(2, "Winter", 200, "Xyz");
    private Product third = new Product(3, "Laptop", 70000);
    private Product forth = new Product(4, "Highlighter", 30);
    private Product fifth = new Smartphone(5, "Iphone", 80000, "Apple");
    private Product sixth = new Smartphone(6, "Honor", 30000, "Huawei");

    @BeforeEach
    public void setting(){
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(forth);
        manager.addProduct(fifth);
        manager.addProduct(sixth);
    }

    @Test
    public void shouldSearchByTextNameBook() {

        Product[] actual = manager.searchBy("Winter");
        Product[] expected = new Product[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextAuthor() {

        Product[] actual = manager.searchBy("Abc");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextNameSmartphone() {

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextProducer() {

        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Product[]{sixth};

        assertArrayEquals(expected, actual);
    }

 //   @Disabled
 //   @Test
 //   public void shouldSearchByTextProduct() {
//
//        Product[] actual = manager.searchBy("Laptop");
//        Product[] expected = new Product[]{third};

  //      Assertions.assertArrayEquals(expected, actual);
  //  }

    @Test
    public void shouldFailSearchByTextIfNotExists() {

        Product[] actual = manager.searchBy("Sample");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}