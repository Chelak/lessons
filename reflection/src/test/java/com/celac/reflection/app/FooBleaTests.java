package com.celac.reflection.app;

import com.celac.reflection.app.entities.FooBlea;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static com.celac.reflection.app.tools.LocalObjectInfoLogger.printInfo;


public class FooBleaTests {

    private List<FooBlea> fooBleaList = Collections.emptyList();

    @Before
    public void prepareSetup() {
        fooBleaList = Arrays.asList(
                new FooBlea("FooBleaMan", 25, 'M'),
                new FooBlea("FooBleaWomen", 22, 'F'),
                new FooBlea("FooBleaManChild", 5, 'F'),
                new FooBlea("FooBleaManChild1", 6, 'M')
        );
    }

    @Test
    public void testFooBleaConsolePrinting() throws IllegalAccessException {
        for (FooBlea fooBlea : fooBleaList) {

            printInfo(fooBlea);
        }
    }
}
