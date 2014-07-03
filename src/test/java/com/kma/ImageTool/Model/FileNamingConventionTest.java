package com.kma.ImageTool.Model;

import com.kma.ImageTool.Error.InvalidImageFileNameException;
import com.kma.ImageTool.Model.naming.FileNamingConvention;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FileNamingConventionTest {

    public static final String IJOS20126_F1_EPS = "IJOS20126.f1";
    public static final String LSA20121_F1 = "LSA20121.f1";
    public static final String EMI201222_F1 = "emi201222.f1";
    public static final String CMI201272_F1 = "cmi201272.f1";
    public static final String SREP_12_03955_T_F01 = "SREP-12-03955-T-f01";
    public static final String CJEM_2012_120613_F1 = "CJEM_2012_120613.f1";
    public static final String BIN2011011_F1 = "bin2011011.f1";
    public static final String JMM057117_1 = "jmm057117-1";
    public static final String JGI123456_F1 = "JGI123456.f1";
    public static final String BJB2148_F1 = "bjb2148.f1";
    public static final String RBP20131162_F1 = "rbp20131162.f1";
    public static final String CDI382541_F1 = "cdi382541.f1";
    public static final String ROT382541_F1 = "rot382541.f1";
    public static final String JBR_2013_0189_F1 = "JBR-2013-0189.f1";
    public static final String CTH377754_F1 = "cth377754.f1";

    @Test(expected = IllegalArgumentException.class)
    public void testShouldGetExceptionHere() throws Exception {
        FileNamingConvention.getOutputFileName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldGetExceptionHere1() throws Exception {
        FileNamingConvention.getOutputFileName(null);
    }

    @Test(expected = InvalidImageFileNameException.class)
    public void testShouldGetExceptionHere2() throws Exception {
        FileNamingConvention.getOutputFileName("a");
    }

    @Test(expected = InvalidImageFileNameException.class)
    public void testShouldGetExceptionHere3() throws Exception {
        FileNamingConvention.getOutputFileName("a.");
    }

    @Test(expected = InvalidImageFileNameException.class)
    public void testShouldGetExceptionHere4() throws Exception {
        FileNamingConvention.getOutputFileName("a.b");
    }

    @Test(expected = InvalidImageFileNameException.class)
    public void testShouldGetExceptionHere5() throws Exception {
        FileNamingConvention.getOutputFileName("a_f");
    }

    @Test(expected = InvalidImageFileNameException.class)
    public void testShouldGetExceptionHere6() throws Exception {
        FileNamingConvention.getOutputFileName("a.f");
    }

    /*
        IJOS

        source file name: IJOS20126.f1.eps(tif)

        renamed: two versions web figures

        Big: ijos20126f1.jpg

        Thumbnails: ijos20126f1th.jpg

    */
    @Test
    public void testIJOSNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "ijos20126f1",
                FileNamingConvention.getOutputFileName(IJOS20126_F1_EPS)
        );
    }

    @Test
    public void testIJOSThumbnailNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "ijos20126f1th",
                FileNamingConvention.getOutputThumbnailFileName(IJOS20126_F1_EPS)
        );
    }

    /*
        LSA

        source file name: LSA20121.f1.eps(tif)

        renamed: two versions web figures

        Big: lsa20121f1.jpg

        Thumbnails: lsa20121f1th.jpg
     */
    @Test
    public void testLSASNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "lsa20121f1",
                FileNamingConvention.getOutputFileName(LSA20121_F1)
        );
    }

    @Test
    public void testLSASThumbnailNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "lsa20121f1th",
                FileNamingConvention.getOutputThumbnailFileName(LSA20121_F1)
        );
    }

    /*
        EMI

        source file name: emi201222.f1.eps(tif)

        renamed: two versions web figures

        Big: emi201222f1.jpg

        Thumbnails: emi201222f1th.jpg
     */
    @Test
    public void testEMINameShouldMatch() throws Exception {
        Assert.assertEquals(
                "emi201222f1",
                FileNamingConvention.getOutputFileName(EMI201222_F1)
        );
    }

    @Test
    public void testEMIThumbnailNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "emi201222f1th",
                FileNamingConvention.getOutputThumbnailFileName(EMI201222_F1)
        );
    }

    /*
        CMI

        source file name: cmi201272.f1.eps(tif)

        renamed: two versions web figures

        Big: cmi201272f1.jpg

        Thumbnails: cmi201272f1th.jpg
     */
    @Test
    public void testCMINameShouldMatch() throws Exception {
        Assert.assertEquals(
                "cmi201272f1",
                FileNamingConvention.getOutputFileName(CMI201272_F1)
        );
    }

    @Test
    public void testCMIThumbnailNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "cmi201272f1th",
                FileNamingConvention.getOutputThumbnailFileName(CMI201272_F1)
        );
    }

    /*

    // TODO SREP
        SREP

        source file name: SREP-12-03955-T-f01.tif

        renamed: srep01385-f1.jpg

        (comments: DOI number=srep01385)
     */

    @Test
    @Ignore
    public void testSREPNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "srep01385-f1",
                FileNamingConvention.getOutputFileName(SREP_12_03955_T_F01)
        );
    }

    /*
        BCD

        renamed :journal_XXXX_XXXXX_fig001.jpg +Thumbnails:journal_XXXX_XXXXX_fth001.jpg

        for example :CJEM

        source file name: CJEM_2012_120613.f1.eps

        renamed: two versions web figures

        Big: CJEM_2012_120613_fig001.jpg

        Thumbnails: CJEM_2012_120613_fth001.jpg
     */

    @Test
    public void testBCDNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "CJEM_2012_120613_fig001",
                FileNamingConvention.getOutputFileName(CJEM_2012_120613_F1)
        );
    }

    @Test
    public void testBCDThumbnailNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "CJEM_2012_120613_fth001",
                FileNamingConvention.getOutputThumbnailFileName(CJEM_2012_120613_F1)
        );
    }

    /*
        BIO

        source file name: bin2011011.f1.tif

        renamed: bio.2011011-f01.tif

    */
    @Test
    public void testBIONameShouldMatch() throws Exception {
        Assert.assertEquals(
                "bio.2011011-f01",
                FileNamingConvention.getOutputFileName(BIN2011011_F1)
        );
    }

    /*
        BJB

        source file name: bjb2148.f1.eps(tif)

        renamed: bjb2148-g01.tif

    */
    @Test
    public void testBJBNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "bjb2148-g01",
                FileNamingConvention.getOutputFileName(BJB2148_F1)
        );
    }

    /*
        AMH

        source file name: JGI123456.f1.eps(tif)

        renamed: jgi.2012.27.12.f01.tif

        • jgi.2012.27.12= the same with PDF
    */
    @Test
    public void testAMHNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "jgi.2012.27.12.f01",
                FileNamingConvention.getOutputFileName(JGI123456_F1)
        );
    }

    /*
        SGM

        source file name: jmm057117-1.eps

        renamed: 057117-1.tif
     */
    @Test
    public void testSGMNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "057117-1",
                FileNamingConvention.getOutputFileName(JMM057117_1)
        );
    }


    /*
        SCI

        source file name: rbp20131162.f1.tif

        renamed: 1516-4446-rbp-2013-35-3-219-gf001.tif

        • 1516-4446-rbp-2013-35-3-219= the same with PDF
    */
    @Test
    public void testSCINameShouldMatch() throws Exception {
        Assert.assertEquals(
                "1516-4446-rbp-2013-35-3-219-gf001",
                FileNamingConvention.getOutputFileName(RBP20131162_F1)
        );
    }

    /*
        NASP

        source file name: spf123456.f1.eps

        renamed: spf-07-02-029-f01.eps

        • spf-07-02-029=the same with PDF
    */
    @Test
    public void testNASPNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "spf-07-02-029-f01",
                FileNamingConvention.getOutputFileName("spf123456.f1")
        );
    }

    /*
        MED

        source file name: cth377754.f1.eps

        renamed: cyh-01-01-022-g001.eps

        • cyh-01-01-022= the same with PDF
    */
    @Test
    public void testMEDNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "cyh-01-01-022-g001",
                FileNamingConvention.getOutputFileName(CTH377754_F1)
        );
    }

    /*
        JBR

        source file name: JBR-2013-0189.f1.eps

        renamed: jbr-27-05-406-g001.eps

        • jbr-27-05-406= the same with PDF
    */
    @Test
    public void testJBRNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "jbr-27-05-406-g001",
                FileNamingConvention.getOutputFileName(JBR_2013_0189_F1)
        );
    }

    /*
        IPEM

        source file name: rot382541.f1.eps(tif)

        renamed: ipem-01-f01.gif
    */
    @Test
    public void testIPEMNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "ipem-01-f01",
                FileNamingConvention.getOutputFileName(ROT382541_F1)
        );
    }

    /*
        CDIC

        source file name: cdi382541.f1.eps(tif)

        renamed: cdic-32-03-164-g001.tif

        • cdic-32-03-164= the same with PDF
     */
    @Test
    public void testCDICNameShouldMatch() throws Exception {
        Assert.assertEquals(
                "cdic-32-03-164-g001",
                FileNamingConvention.getOutputFileName(CDI382541_F1)
        );
    }


    // TODO: fix ignored test
    // TODO: integrate into convertion process
    // TODO: implement - don't change figure name for following cases: NTU CRM PLOS, TTP, Maney / IOM, ERS (erj, erm and err), USP, JCS, PUP, TPM, No need change figure name
}