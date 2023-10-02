package ru.netology.ticket.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketCompareTest {
    @Test
    public void shouldCompareTicketTree() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19);
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17);
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "KRS");
        Ticket[] expected = {ticket6, ticket5, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19);
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17);
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "UFA");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketZero() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19);
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11);
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17);
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("SPB", "UFA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorTree() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19); //6!
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16); //2
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11); //1
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17); //6
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);//5!
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);//7!

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "KRS", comparator);
        Ticket[] expected = {ticket5, ticket1, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19); //6!
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16); //2
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11); //1
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17); //6
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);//5!
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);//7!

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "KRS", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketWithComparatorZero() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "KRS", 20000, 13, 19); //6!
        Ticket ticket2 = new Ticket("MSK", "UFA", 10000, 14, 16); //2
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 11); //1
        Ticket ticket4 = new Ticket("SPB", "KRS", 21000, 11, 17); //6
        Ticket ticket5 = new Ticket("MSK", "KRS", 15000, 10, 15);//5!
        Ticket ticket6 = new Ticket("MSK", "KRS", 11000, 8, 15);//7!

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "UFA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
