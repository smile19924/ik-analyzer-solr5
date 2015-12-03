package org.wltea.analyzer.lucene;

import java.util.Map;

import org.apache.lucene.analysis.util.ResourceLoaderAware;
import org.apache.lucene.analysis.util.TokenizerFactory;


public abstract class ReloadableTokenizerFactory extends TokenizerFactory implements ResourceLoaderAware{
	
	protected String conf;
	
	protected ReloadableTokenizerFactory(Map<String, String> args) {
		super(args);
		conf = get(args, "conf");
	}

	public abstract void update();
	
	public String getBeanName(){
		return this.getClass().toString();
	}
}
