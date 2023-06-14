package br.edu.ifsp.application.main;


import br.edu.ifsp.application.repository.*;
import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.booking.BookingStatus;
import br.edu.ifsp.domain.entities.cashier.Cashier;
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
import br.edu.ifsp.domain.usecases.cashier.CashierDAO;
import br.edu.ifsp.domain.usecases.cashier.OpenCashierUseCase;
import br.edu.ifsp.domain.usecases.category.*;
import br.edu.ifsp.domain.usecases.product.*;
import br.edu.ifsp.domain.usecases.room.*;
import br.edu.ifsp.domain.usecases.user.*;

import java.time.LocalDate;

public class Main {

    public static OpenCashierUseCase openCashierUseCase;
    public static CreateProductUseCase createProductUseCase;
    public static ListProductsUseCase listProductsUseCase;
    public static UpdateProductUseCase updateProductUseCase;
    private static DisableProductUseCase disableProductUseCase;

    public static CreateRoomUseCase createRoomUseCase;
    public static UpdateRoomUseCase updateRoomUseCase;
    public static DisableRoomUseCase disableRoomUseCase;
    public static FindRoomUseCase findRoomUseCase;

    public static CreateCategoryUseCase createCategoryUseCase;
    public static UpdateCategoryUseCase updateCategoryUseCase;
    public static DisableCategoryUseCase disableCategoryUseCase;
    public static ListCategoriesUseCase listCategoryUseCase;

    public static CreateBookingUseCase createBookingUseCase;
    public static UpDateBookingUseCase upDateBookingUseCase;
    public static FinishBookingUseCase finishBookingUseCase;
    public static findBookingUseCase findBookingUseCase;


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

        /**----------------User--------------*/

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

        /**----------------Room--------------*/

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

        /**----------------Category--------------*/

        Category master = new Category(1,"MASTER", CategoryStatus.AVAILABLE);
        master.addRoom(room101);
        master.addRoom(room102);
        master.setCategoryPrice(CategoryPrice.ONE_HOUR, 300.00);
        master.setCategoryPrice(CategoryPrice.TWO_HOURS, 500.00);
        master.setCategoryPrice(CategoryPrice.ALL_NIGHT, 600.00);
        master.setCategoryPrice(CategoryPrice.ADDITIONAL_HOUR, 300.00);

        Category luxo = new Category(2,"Luxo", CategoryStatus.AVAILABLE);
        luxo.addRoom(room201);
        luxo.addRoom(room202);
        luxo.setCategoryPrice(CategoryPrice.ONE_HOUR, 200.00);
        luxo.setCategoryPrice(CategoryPrice.TWO_HOURS, 300.00);
        luxo.setCategoryPrice(CategoryPrice.ALL_NIGHT, 400.00);
        luxo.setCategoryPrice(CategoryPrice.ADDITIONAL_HOUR, 200.00);

        Category simples = new Category(3,"Simples", CategoryStatus.AVAILABLE);
        simples.addRoom(room301);
        simples.addRoom(room302);
        simples.setCategoryPrice(CategoryPrice.ONE_HOUR, 100.00);
        simples.setCategoryPrice(CategoryPrice.TWO_HOURS, 1500.00);
        simples.setCategoryPrice(CategoryPrice.ALL_NIGHT, 200.00);
        simples.setCategoryPrice(CategoryPrice.ADDITIONAL_HOUR, 100.00);

        createCategoryUseCase.insert(master);
        createCategoryUseCase.insert(luxo);
        createCategoryUseCase.insert(simples);


        Booking booking1 = new Booking(1,201,"Master", "1 Hora",
                LocalDate.of(2023, 5, 1).atStartOfDay(), LocalDate.of(2023, 5, 2).atStartOfDay(), BookingStatus.OPEN);
        createBookingUseCase.insert(booking1);
//
//        Booking booking2 = new Booking(1,simples.selectRoom(0), simples.getNameCategory(),
//                simples.getPriceBy(CategoryPrice.ONE_HOUR),
//                ,
//                , true);
//        createBookingUseCase.insert(booking1);
//
//        Booking booking3 = new Booking(1,luxo.selectRoom(0), luxo.getNameCategory(),
//                luxo.getPriceBy(CategoryPrice.TWO_HOURS),
//                LocalDate.of(2023, 5, 1),
//                LocalDate.of(2023, 5, 2), true);
//        createBookingUseCase.insert(booking1);


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
        listCategoryUseCase = new ListCategoriesUseCase(categoryDAO);

        BookingDAO bookingDAO = new InMemoryBookingDAO();
        createBookingUseCase = new CreateBookingUseCase(bookingDAO);
        upDateBookingUseCase = new UpDateBookingUseCase(bookingDAO);
        finishBookingUseCase = new FinishBookingUseCase(bookingDAO);
        findBookingUseCase = new findBookingUseCase(bookingDAO);

        UserDAO userDAO = new InMemoryUserDAO();
        createUserUseCase = new CreateUserUseCase(userDAO);
        autenticationUserUseCase = new AutenticationUserUseCase(userDAO);
        findUserUseCase = new FindUserUseCase(userDAO);
        disableUserUseCase = new DisableUserUseCase(userDAO);
        updateUserUseCase = new UpdateUserUseCase(userDAO);

        CashierDAO cashierDAO = new  InMemoryCashierDAO();
        openCashierUseCase =new OpenCashierUseCase(cashierDAO);

    }
}
