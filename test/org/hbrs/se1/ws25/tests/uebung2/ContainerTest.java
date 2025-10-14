package org.hbrs.se1.ws25.tests.uebung2;

import org.hbrs.se1.ws25.exercises.uebung2.Container;
import org.hbrs.se1.ws25.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws25.exercises.uebung2.ContainerException;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container container;
    private ConcreteMember member1;
    private ConcreteMember member2;

    @BeforeEach
    public void setUp() {
        container = new Container();
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
    }

    @Test
    public void addMemberTest() throws ContainerException {
        container.addMember(member1);
        assertEquals(1, container.size());

        container.addMember(member2);
        assertEquals(2, container.size());
    }

    @Test
    public void duplicateMemberTest() throws ContainerException {
        container.addMember(member1);
        ContainerException cex = assertThrows(ContainerException.class, () -> container.addMember(new ConcreteMember(1)));
        assertTrue(cex.getMessage().contains("Das Member-Objekt mit der ID 1 ist bereits vorhanden!"));
    }

    @Test
    public void deleteMemberTest() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);

        container.deleteMember(2);
        assertEquals(1, container.size());

        container.deleteMember(3);
        assertEquals(1, container.size());
    }

    @Test
    public void idTest() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);

        assertEquals("Member (ID = 1)", member1.toString());
        assertEquals("Member (ID = 2)", member2.toString());
    }


}