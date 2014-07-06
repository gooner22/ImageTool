package com.kma.ImageTool.Model.naming;

import com.kma.ImageTool.Error.InvalidImageFileNameException;
import com.kma.ImageTool.Model.naming.strategy.impl.StrategyChooser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class FileNamingConvention {


    public static final List<String> POSSIBLE_REGEXS = Arrays.asList(
            Constants.REGEX_BCD,
            Constants.REGEX_SGM,
            Constants.REGEX_GENERAL,
            Constants.REGEX_BIO,
            Constants.REGEX_BJB);
    private static StrategyChooser strategyChooser = new StrategyChooser();

    public static String getOutputFileName(final String sourceFileName) throws InvalidImageFileNameException {
        return strategyChooser.getFileName(getMatcher(sourceFileName));
    }

    public static String getOutputThumbnailFileName(final String sourceFileName) throws InvalidImageFileNameException {
        return strategyChooser.getThumbnailFileName(getMatcher(sourceFileName));
    }

    public static int getOutputNumberOfFile(final String sourceFileName) {
        try {
            return strategyChooser.getNumberOfFile(getMatcher(sourceFileName));
        } catch (InvalidImageFileNameException e) {
            System.out.println("Can not find strategy for file named: " + sourceFileName);
            return -1;
        }
    }

    private static MatcherWrapper getMatcher(String sourceFileName) throws InvalidImageFileNameException {

        if(sourceFileName == null ||
                sourceFileName.isEmpty())
            throw new IllegalArgumentException();


         // try to find corresponding regex
            for (String regex : POSSIBLE_REGEXS){
            Matcher m = Pattern.compile(regex).matcher(sourceFileName);
            if (m.matches()){
                return new MatcherWrapper(m, regex);
            }
        }

        // throw exception in case sourceFileName didn't match any pattern
        throw new InvalidImageFileNameException("source file named:'" + sourceFileName + "' doesn't match pattern.");
    }
}
