package com.github.eragontuan.cinema_project03_11_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.github.eragontuan.cinema_project03_11_2018.Models.Common;
import com.github.eragontuan.cinema_project03_11_2018.Models.Movie;
import com.github.eragontuan.cinema_project03_11_2018.Models.MovieAdapter;

import org.w3c.dom.Text;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class News_Film extends AppCompatActivity {

    private FeatureCoverFlow mCoverFlow;
    private MovieAdapter mMovieAdapter;
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__film);

        initData();

        //TODO: references_to_widget activity_news_film.xml (layout)
        references_to_widget();

        //TODO:
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(News_Film.this);
                TextView txt = (TextView) inflater.inflate(R.layout.layout_title, null);
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);

        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);


        mMovieAdapter = new MovieAdapter(Common.mMovieList, this);
        mCoverFlow.setAdapter(mMovieAdapter);


        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.mMovieList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });
        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(News_Film.this, MovieDetail.class);
                intent.putExtra("movie_index", position);
                startActivity(intent);
            }
        });
    }

    private void references_to_widget() {
        mTitle = (TextSwitcher) findViewById(R.id.title);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);

    }
/*
* Movie(int running_time,
* String name,
* String imageURL,
* String summary,
* String director,
* String cast,
* String genre,
* String release_date,
* String rated_URL,
* String language)
* */

    /*URL
     * P:    https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/P-_VIETNAM.png/800px-P-_VIETNAM.png
     * C13:  https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/C13_VIETNAM.png/800px-C13_VIETNAM.png
     * C16:  https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/C16_VIETNAM.png/800px-C16_VIETNAM.png
     * C18:  https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/C18_VIETNAM.png/800px-C18_VIETNAM.png
     * */
    private void initData() {
        Common.mMovieList.add(new Movie(95, "THE GRINCH", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/g/r/grinch160x237_2.jpg", "The Grinch là một kẻ cô độc, suốt ngày cau có. Hắn không sống chung với bất kỳ ai mà ở trong hang núi với một chú chó. Bị bỏ rơi từ nhỏ, hắn luôn ganh tị với niềm hạnh phúc của tất cả mọi người. Cũng chính vì thế, The Grinch đã âm mưu phá hoại lễ giáng sinh của dân làng.", "Yarrow Cheney, Scott Mosier", "Benedict Cumberbatch", "Hoạt Hình", "09/11/2018", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/P-_VIETNAM.png/800px-P-_VIETNAM.png", "Tiếng Anh với phụ đề và lồng tiếng Việt"));
        Common.mMovieList.add(new Movie(120 , "CÔ GÁI TRONG LƯỚI NHỆN ẢO", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/1/6/160_3_5.jpg", "Được chuyển thể từ loạt tiểu thuyết trinh thám bán chạy nhất của Thuỵ Điển, sê-ri phim The Girl with the Dragon Tattoo từng được yêu thích trên màn ảnh rộng", "Fede Alvarez", "Claire Foy, Sverrir Gudnason, Sylvia Hoeks,...", "Hành Động, Tội phạm", "09/11/2018", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/C18_VIETNAM.png/800px-C18_VIETNAM.png", "Tiếng Anh với phụ đề tiếng Việt"));
        Common.mMovieList.add(new Movie(132 , "NGƯỜI BẤT TỬ", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/p/o/poster_160_1_2.jpg", "Những giấc mơ khó hiểu và ám ảnh đã đưa An (Đinh Ngọc Diệp) tới một hang động kì bí, nơi cô phát hiện ra bí mật khủng khiếp của Hùng (Quách Ngọc Ngoan) - người đàn ông sống qua 3 thế kỷ. Cuộc đời thăng trầm của Hùng với đầy những tham vọng, thù hận và ma thuật dần được mở ra.", "Victor Vũ", "Quách Ngọc Ngoan, Đinh Ngọc Diệp, Jun Vũ, Thanh Tú, Cường Seven, Trương Thế Vinh, Vũ Tuấn Việt, Chiều Xuân, Bùi Bài Bình, Francois Negret…", "Kịch tính, Tâm Lý", "26/10/2018", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/C18_VIETNAM.png/800px-C18_VIETNAM.png", "Tiếng Việt với phụ đề Tiếng Anh"));
        Common.mMovieList.add(new Movie(100, "KẸP HẠT DẺ VÀ BỐN VƯƠNG QUỐC", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/1/6/160_2_14.jpg", "Tất cả những gì mà Clara (Mackenzie Foy) khao khát tìm chỉ là một chiếc chìa có thể mở ra chiếc hộp lưu giữ một món quà vô giá từ người mẹ của mình. Một sợi chỉ vàng được đưa đến cho cha đỡ đầu của cô Drosselmeyer (Morgan Freeman) tại bữa tiệc mừng lễ hằng năm và dẫn đường cho Clara đến chỗ chiếc chìa khóa bí ẩn. Tuy nhiên, chiếc chìa khóa nhanh chóng biến mất vào một thế giới song song vô cùng kỳ lạ. Tại đó, cô bắt gặp một anh lính tên là Phillip (Jayden Fowora Knight), một băng chuột nhắt và các vị quan nhiếp chính cai quản ba vương quốc: Vùng đất Tuyết, Vùng đất Hoa và Vùng đất Kẹo Ngọt. Họ phải sẵn sàng đối mặt với những hiểm họa khôn lường tại vương quốc thứ tư, quê hương của bạo chúa Mother Ginger (Helen Mirren) để đoạt lại chiếc chìa khóa của Clara và hy vọng rằng có thể đảm bảo sự yên bình của thế giới hỗn loạn. Một vùng đất nhiệm mầu được mở ra trước mắt nhưng đang lâm nguy, liệu công chúa Clara có sẵn sàng chiến đấu? NUTCRACKER AND THE FOUR REALMS – Kẹp Hạt Dẻ Và Bốn Vương Quốc dự kiến khởi chiếu vào ngày 2.11.2018 tại các rạp trên toàn quốc.", "Joe Johnston, Lasse Hallström", "Mackenzie Foy, Keira Knightley, Morgan Freeman, Eugenio Derbez", "Bí ẩn, Phiêu Lưu", "02/11/2018", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/P-_VIETNAM.png/800px-P-_VIETNAM.png", "Tiếng Anh với phụ đề tiếng Việt"));
        Common.mMovieList.add(new Movie(117, "DẠ QUỶ", "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/1/6/160_3_10.jpg", "Dạ Quỷ là bộ phim xoay quanh cuộc chiến xác sống từ triều đại xưa tại Hàn Quốc. Hoàng tử Lee, một người tài năng của triều đại Joseon vừa trở về sau thời gian lưu đày bởi giặc xâm lược. Giữa tình thế đất nước lâm vào cơn “đại dịch bóng đêm” cùng hàng loạt thù trong giặc ngoài, hoàng tử Lee sẽ làm gì với những kẻ thù đến từ bóng đêm?", "Kim Sung-hoon", "Hyun Bin, Jang Dong Gun", "Hành Động, Kinh Dị", "02/11/2018", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/C18_VIETNAM.png/800px-C18_VIETNAM.png", "Tiếng Hàn với phụ đề tiếng Việt"));
       }
}
