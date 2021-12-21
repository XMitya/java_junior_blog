package ru.ifmo.blog.dao.postgres;

import org.junit.jupiter.api.*;
import ru.ifmo.blog.dao.AbstractDaoFactory;
import ru.ifmo.blog.dao.UserDao;
import ru.ifmo.blog.entity.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostgresUserDaoTest {

    UserDao userDao;

    @BeforeEach
    void setUp() throws SQLException {
        userDao = AbstractDaoFactory.getDaoFactory().createUserDao();
        userDao.removeAll();
    }

    @BeforeAll
    static void init() throws SQLException {
        final AbstractDaoFactory daoFactory = AbstractDaoFactory.getDaoFactory();
        daoFactory.connect("localhost", "ifmo", "ifmo", "q1w2e3");
    }

    @AfterAll
    static void afterAll() throws SQLException {
        final AbstractDaoFactory daoFactory = AbstractDaoFactory.getDaoFactory();
        AbstractDaoFactory.getDaoFactory().createUserDao().removeAll();
        daoFactory.close();
    }

    @Test
    public void shouldGetEmptyWhenNoData() throws SQLException {
        assertThat(userDao.get(1L)).isEmpty();
    }

    @Test
    public void shouldInsertAndGet() throws Exception {
        final User user = new User(1L, "name", "login", "password", LocalDateTime.now(), 18);

        userDao.save(user);

        final Optional<User> actual = userDao.get(1L);

        assertThat(actual).isEqualTo(Optional.of(user));
    }
}