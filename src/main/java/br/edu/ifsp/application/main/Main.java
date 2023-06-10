package br.edu.ifsp.application.main;


import br.edu.ifsp.application.repository.*;
import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.category.CategoryStatus;
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

    private static CreateProductUseCase createProductUseCase;
    private static ListProductsUseCase listProductsUseCase;
    private static UpdateProductUseCase updateProductUseCase;
    private static DisableProductUseCase disableProductUseCase;

    private static CreateRoomUseCase createRoomUseCase;
    private static UpdateRoomUseCase updateRoomUseCase;
    private static DisableRoomUseCase disableRoomUseCase;
    private static ListRoomsUseCase listRoomsUseCase;

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
        listRoomsUseCase = new ListRoomsUseCase(roomDAO);

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
