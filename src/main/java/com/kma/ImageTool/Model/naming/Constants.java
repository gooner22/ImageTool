package com.kma.ImageTool.Model.naming;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class Constants {
    // general pattern
    //  *(.*)\. *([f])+ *(\d)+

    // BCD
    //  *(.*)\_+ *(.*)\_+ *(.*)\. *([f])+ *(\d)+

    // JMM
    //  *(\d+)*\- *(\d+)

    // BJB
    // *(.*)[^\d] *(\d*)f *(\d+)

    public static final String SPECIAL_SYMBOL_SEPARATOR_DOT = ".";
    public static final String SPECIAL_SYMBOL_SEPARATOR_HYPHEN = "-";
    public static final String SPECIAL_SYMBOL_SEPARATOR_UNDERSCORE = "_";

    public static final String SYMBOLIC_SEPARATOR = "f";
    public static final String SYMBOLIC_SEPARATOR_FIG = "fig";
    public static final String SYMBOLIC_SEPARATOR_FTH = "fth";

    public static final String THUMBNAIL_SUFFIX = "th";

    public static final String REGEX_GENERAL = " *(.*)\\" + SPECIAL_SYMBOL_SEPARATOR_DOT + " *([" + SYMBOLIC_SEPARATOR + "])+ *(\\d+)";
    public static final String REGEX_BCD = " *(.*\\_+.*\\_+.*)\\" + SPECIAL_SYMBOL_SEPARATOR_DOT + " *([" + SYMBOLIC_SEPARATOR + "])+ *(\\d+)";
    public static final String REGEX_HYPHEN_SEPARATOR = " *(.+)\\" + SPECIAL_SYMBOL_SEPARATOR_HYPHEN + " *([" + SYMBOLIC_SEPARATOR + "])+ *(\\d+)";
    public static final String REGEX_SGM = " *(.*)[^\\d] *(\\d+)\\" + SPECIAL_SYMBOL_SEPARATOR_HYPHEN + " *(\\d+)";
    public static final String REGEX_BJB = " *(.*)[^\\d] *(\\d*)" + SYMBOLIC_SEPARATOR + " *(\\d+)";
    public static final String REGEX_BIO = " *(.*)[^\\d] *(\\d*)" + SPECIAL_SYMBOL_SEPARATOR_DOT + SYMBOLIC_SEPARATOR + " *(\\d+)";
}
