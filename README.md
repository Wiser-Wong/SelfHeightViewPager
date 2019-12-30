# SelfHeightViewPager
自适应高度的ViewPager

## 环境配置
    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }

        dependencies {
              implementation 'com.github.Wiser-Wong:SelfHeightViewPager:1.0.0'
      }

## 使用说明

            <com.wiser.self_vp.SelfHeightViewPager
                android:id="@+id/vp"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:svp_scroll="true"/>

            <com.wiser.self_vp.SelfHeightViewPagerN
                android:id="@+id/vp"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:svpn_scroll="true"/>

    @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            SelfHeightViewPagerN.resetHeight(position);//或
            //SelfHeightViewPager.requestLayout();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
