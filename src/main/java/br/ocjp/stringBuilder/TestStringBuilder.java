package br.ocjp.stringBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringBuilder {

    private StringBuilder sb;

    @Before
    public void initStringBuild(){
        sb = new StringBuilder("default");
    }

    @Test
    public void testAppend(){
        sb.append("willian");
        sb.append("bueno");
        Assert.assertEquals("defaultwillianbueno",sb.toString());
    }

    @Test
    public void testInsert(){
        sb.insert(2,"teste");
        Assert.assertEquals("detestefault",sb.toString());
    }

    @Test
    public void testDelete(){
        sb.delete(2,4);
        Assert.assertEquals("deult",sb.toString());
    }

    @Test
    public void testDeleteCharAt(){
        sb.deleteCharAt(1);
        Assert.assertEquals("dfault",sb.toString());
    }

    @Test
    public void testReplace(){
        sb.replace(0,3,"teste");
        Assert.assertEquals("testeault",sb.toString());
    }

    @Test
    public void testReverse(){
        sb.reverse();
        Assert.assertEquals("tluafed",sb.toString());
    }

    @Test
    public void testIndexOf(){
        Assert.assertEquals(2,sb.indexOf("f"));
    }

    @Test
    public void testLastIndexOf(){
        Assert.assertEquals(2,sb.indexOf("f"));
    }

    @Test
    public void testCharAt(){
        Assert.assertEquals('d',sb.charAt(0));
    }


}
