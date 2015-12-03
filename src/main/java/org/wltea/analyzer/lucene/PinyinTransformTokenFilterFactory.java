package org.wltea.analyzer.lucene;

import java.util.Map;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class PinyinTransformTokenFilterFactory extends TokenFilterFactory {
	  private boolean isOutChinese = true;
	  private int minTermLength = 2;
	  private boolean firstChar = false;

	  public PinyinTransformTokenFilterFactory(Map<String, String> args)
	  {
	    super(args);
	    this.isOutChinese = getBoolean(args, "isOutChinese", true);
	    this.firstChar = getBoolean(args, "firstChar", false);
	    this.minTermLength = getInt(args, "minTermLength", 2);
	    if (!args.isEmpty())
	      throw new IllegalArgumentException("Unknown parameters: " + args);
	  }

	  @Override
	  public TokenFilter create(TokenStream input) {
	    return new PinyinTransformTokenFilter(input, this.firstChar, 
	      this.minTermLength, this.isOutChinese);
	  }

}
