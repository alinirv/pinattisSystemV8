package br.edu.ifsp.application.main;


import br.edu.ifsp.application.repository.*;
import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.category.CategoryStatus;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.product.ProductStatus;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.user.UserStatus;
import br.edu.ifsp.domain.entities.user.UserType;
import br.edu.ifsp.domain.usecases.booking.*;
import br.edu.ifsp.domain.usecases.category.*;
import br.edu.ifsp.domain.usecases.product.*;
import br.edu.ifsp.domain.usecases.room.*;
import br.edu.ifsp.domain.usecases.user.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static CreateProductUseCase createProductUseCase;
    public static ListProductsUseCase listProductsUseCase;
    public static UpdateProductUseCase updateProductUseCase;
    private static DisableProductUseCase disableProductUseCase;

    public static CreateRoomUseCase createRoomUseCase;
    public static UpdateRoomUseCase updateRoomUseCase;
    public static DisableRoomUseCase disableRoomUseCase;
    public static FindRoomUseCase findRoomUseCase;

    private static CreateCategoryUseCase createCategoryUseCase;
    private static UpdateCategoryUseCase updateCategoryUseCase;
    private static DisableCategoryUseCase disableCategoryUseCase;
    private static ListCategoriesUseCase listCategoriesUseCase;

    private static CreateBookingUseCase createBookingUseCase;
    private static UpDateBookingUseCase upDateBookingUseCase;
    private static FinishBookingUseCase finishBookingUseCase;
    private static ListBookingUseCase listBookingUseCase;

    private static ListBookingByIdUseCase listBookingByIdUseCase;


    public static AutenticationUserUseCase autenticationUserUseCase;
    public static CreateUserUseCase createUserUseCase;
    public static FindUserUseCase findUserUseCase;
    public static DisableUserUseCase disableUserUseCase;
    public static UpdateUserUseCase updateUserUseCase;


    public static void main(String[] args) {
        configInjections();
        populateFakeDataBase();
        WindowLoader.main(args);
    }

    private static void populateFakeDataBase() {
        User user1 = new User(10,"Ronaldo","12345678912","1234",UserType.ADMIN,UserStatus.ACTIVE);
        User user2 = new User(11,"Paola","11111111111","1234",UserType.MAINTAINER,UserStatus.ACTIVE);
        User user3 = new User("Everton","33333333333",UserType.MAINTAINER);
        User user4 = new User("Aline","22222222222",UserType.MAINTAINER);
        User user5 = new User("Eduardo","25836978912",UserType.MAINTAINER);
        createUserUseCase.insert(user1);
        createUserUseCase.insert(user2);
        createUserUseCase.insert(user3);
        createUserUseCase.insert(user4);
        createUserUseCase.insert(user5);

        //Adiciona quarto

        Room room101 = new Room(1,101, RoomStatus.AVAILABLE);
        Room room102 = new Room(2,102, RoomStatus.AVAILABLE);
        Room room201 = new Room(3,201, RoomStatus.AVAILABLE);
        Room room202 = new Room(4,202, RoomStatus.AVAILABLE);
        Room room301 = new Room(5,301, RoomStatus.AVAILABLE);
        Room room302 = new Room(6,302, RoomStatus.AVAILABLE);
        createRoomUseCase.insert(room101);
        createRoomUseCase.insert(room102);
        createRoomUseCase.insert(room201);
        createRoomUseCase.insert(room202);
        createRoomUseCase.insert(room301);
        createRoomUseCase.insert(room302);

        /**----------------Product--------------*/
        // Adiciona produtos
        Product product_1 = new Product("Vinho Tinto", 50.00, ProductStatus.ACTIVE);
        Product product_2 = new Product("Vinho Espumante", 50.00, ProductStatus.ACTIVE);
        Product product_3 = new Product("Chocolate", 10.00, ProductStatus.ACTIVE);
        Product product_4 = new Product("Agua Mineral", 20.00, ProductStatus.ACTIVE);
        Product product_5 = new Product("Cerveja Lata", 10.00, ProductStatus.ACTIVE);
        createProductUseCase.insert(product_1);
        createProductUseCase.insert(product_2);
        createProductUseCase.insert(product_3);
        createProductUseCase.insert(product_4);
        createProductUseCase.insert(product_5);

    }

    private static void configInjections() {
        ProductDAO productDAO = new InMemoryProductDAO();
        createProductUseCase = new CreateProductUseCase(productDAO);
        updateProductUseCase = new UpdateProductUseCase(productDAO);
        listProductsUseCase = new ListProductsUseCase(productDAO);
        disableProductUseCase = new DisableProductUseCase(productDAO);

        RoomDAO roomDAO = new InMemoryRoomDAO();
        createRoomUseCase = new CreateRoomUseCase(roomDAO);
        updateRoomUseCase = new UpdateRoomUseCase(roomDAO);
        disableRoomUseCase = new DisableRoomUseCase(roomDAO);
        findRoomUseCase = new FindRoomUseCase(roomDAO);

        CategoryDAO categoryDAO = new InMemoryCategoryDAO();
        createCategoryUseCase = new CreateCategoryUseCase(categoryDAO);
        updateCategoryUseCase = new UpdateCategoryUseCase(categoryDAO);
        disableCategoryUseCase = new DisableCategoryUseCase(categoryDAO);
        listCategoriesUseCase = new ListCategoriesUseCase(categoryDAO);

        BookingDAO bookingDAO = new InMemoryBookingDAO();
        createBookingUseCase = new CreateBookingUseCase(bookingDAO);
        upDateBookingUseCase = new UpDateBookingUseCase(bookingDAO);
        finishBookingUseCase = new FinishBookingUseCase(bookingDAO);
        listBookingUseCase = new ListBookingUseCase(bookingDAO);

        UserDAO userDAO = new InMemoryUserDAO();
        createUserUseCase = new CreateUserUseCase(userDAO);
        autenticationUserUseCase = new AutenticationUserUseCase(userDAO);
        findUserUseCase = new FindUserUseCase(userDAO);
        disableUserUseCase = new DisableUserUseCase(userDAO);
        updateUserUseCase = new UpdateUserUseCase(userDAO);

    }
}
