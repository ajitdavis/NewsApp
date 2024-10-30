package com.example.newsgenz;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.newsgenz.databinding.ActivityArticleBindingImpl;
import com.example.newsgenz.databinding.ActivityMainBindingImpl;
import com.example.newsgenz.databinding.FragmentCategoryBindingImpl;
import com.example.newsgenz.databinding.FragmentSavedNewsBindingImpl;
import com.example.newsgenz.databinding.FragmentTopNewsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYARTICLE = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_FRAGMENTCATEGORY = 3;

  private static final int LAYOUT_FRAGMENTSAVEDNEWS = 4;

  private static final int LAYOUT_FRAGMENTTOPNEWS = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.newsgenz.R.layout.activity_article, LAYOUT_ACTIVITYARTICLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.newsgenz.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.newsgenz.R.layout.fragment_category, LAYOUT_FRAGMENTCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.newsgenz.R.layout.fragment_saved_news, LAYOUT_FRAGMENTSAVEDNEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.newsgenz.R.layout.fragment_top_news, LAYOUT_FRAGMENTTOPNEWS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYARTICLE: {
          if ("layout/activity_article_0".equals(tag)) {
            return new ActivityArticleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_article is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORY: {
          if ("layout/fragment_category_0".equals(tag)) {
            return new FragmentCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_category is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSAVEDNEWS: {
          if ("layout/fragment_saved_news_0".equals(tag)) {
            return new FragmentSavedNewsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_saved_news is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTOPNEWS: {
          if ("layout/fragment_top_news_0".equals(tag)) {
            return new FragmentTopNewsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_top_news is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_article_0", com.example.newsgenz.R.layout.activity_article);
      sKeys.put("layout/activity_main_0", com.example.newsgenz.R.layout.activity_main);
      sKeys.put("layout/fragment_category_0", com.example.newsgenz.R.layout.fragment_category);
      sKeys.put("layout/fragment_saved_news_0", com.example.newsgenz.R.layout.fragment_saved_news);
      sKeys.put("layout/fragment_top_news_0", com.example.newsgenz.R.layout.fragment_top_news);
    }
  }
}
