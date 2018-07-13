package com.hesen.share.web.lang;

import com.hesen.share.common.enums.ResEnum;
import com.hesen.share.facade.information.InformationFacede;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hesen
 */
public class JdkTest {

    @Test
    public void classToString(){
        System.out.println(InformationFacede.class.toGenericString());
    }

    @Test
    public void collectorsTest(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.averagingDouble(d -> d*2));
        System.out.println(result);

        Double result2 = list.stream().collect(Collectors.averagingInt(v->v*2));
        System.out.println(result2);

        Double result3 = list.stream().collect(Collectors.averagingLong(v->v*2));
        System.out.println(result3);

        Double result4 = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v->v*2),
                s-> s*s));
        System.out.println(result4);

        long result5 =  list.stream().collect(Collectors.counting());
        System.out.println(result5);
    }

    @Test
    public void collectorsOtherTest(){
        List<String> list1 = Arrays.asList("A","B","C","D");
        String result=  list1.stream().collect(Collectors.joining(",","(",")"));
        System.out.println(result);

        List<Integer> list = Arrays.asList(30,10,20,35);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("Max:" + max + "--Min:" + min);
        //Get Max
        list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(i->System.out.println(i));
        //Get Min
        list.stream().collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(i->System.out.println(i));
    }

    @Test
    public void stringTest(){
        String str = "123";
        int i = str.codePointAt(3);
        System.out.println(i);
    }

    @Test
    public void enumTest(){
        String name = ResEnum.RES_CODE_FAIL.name();
        int ordinal = ResEnum.SYSTEM_ERROR.ordinal();
        System.out.println(name + "----" + ordinal);
    }

}
