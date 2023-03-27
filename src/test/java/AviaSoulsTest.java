import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 10_000, 10, 15);
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 5000, 12, 15);
    Ticket ticket3 = new Ticket("Москва", "Санкт-Петербург", 1000, 10, 12);
    Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 15_000, 16, 20);
    Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 12_000, 10, 11);

    @Test
    public void shouldSortByPrice() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        Arrays.sort(tickets.findAll());

        Ticket[] expected = {ticket3, ticket2, ticket1, ticket5, ticket4};
        Ticket[] actual = tickets.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindRouteWithMinPrice() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);


        Ticket[] expected = {ticket3, ticket2, ticket1, ticket5, ticket4};
        Ticket[] actual = tickets.search("Москва", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortByFlightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        Arrays.sort(tickets.findAll(), timeComparator);

        Ticket[] expected = {ticket5, ticket3, ticket2, ticket4, ticket1};
        Ticket[] actual = tickets.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortByRouteWithMinFlightTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);


        Ticket[] expected = {ticket5, ticket3, ticket2, ticket4, ticket1};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Санкт-Петербург", timeComparator);
        Assertions.assertArrayEquals(expected, actual);


    }

}
