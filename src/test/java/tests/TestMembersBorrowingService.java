package tests;

import lab5.BorrowingService;
import lab5.Member;
import lab5.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMembersBorrowingService {
    BorrowingService service = BorrowingService.getInstance();
    @Test
    void TestMemberServices() {
        Member member1 = new Member("Member 1"); Member member2 = new
                Member("Member 2");
        assertEquals(member1.getBorrowingService(),
                member2.getBorrowingService(),
                "Members have two different borrowing services");
    }
}

