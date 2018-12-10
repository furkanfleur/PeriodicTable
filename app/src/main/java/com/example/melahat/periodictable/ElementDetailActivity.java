package com.example.melahat.periodictable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.melahat.periodictable.databinding.ActivityElementDetailBinding;

public class ElementDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_element_detail);

        ActivityElementDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_element_detail);

        PeriodicTable.Element element = getIntent().getParcelableExtra("element");
        String holder;

        if (element.name != null) {
            holder = element.name.substring(0, 1).toUpperCase() + element.name.substring(1);
            binding.elementText.setText(holder);
        } else {
            binding.elementText.setText("-");
        }

        if (element.category != null) {
            holder = element.category.substring(0, 1).toUpperCase() + element.category.substring(1);
            binding.categoryText.setText(holder);
        } else {
            binding.elementText.setText("-");
        }

        if (element.appearance != null) {
            holder = element.appearance.substring(0, 1).toUpperCase() + element.appearance.substring(1);
            binding.appereanceText.setText(holder);
        } else {
            binding.appereanceText.setText("-");
        }

        if (element.discovered_by != null) {
            holder = element.discovered_by.substring(0, 1).toUpperCase() + element.discovered_by.substring(1);
            binding.discovererText.setText(holder);
        } else {
            binding.discovererText.setText("-");
        }

        if (element.named_by != null) {
            holder = element.named_by.substring(0, 1).toUpperCase() + element.named_by.substring(1);
            binding.namedText.setText(holder);
        } else {
            binding.namedText.setText("-");
        }

        if (element.atomic_mass != null) {
            binding.massText.setText(element.atomic_mass.toString());
        } else {
            binding.massText.setText("-");
        }

        if (element.density != null) {
            binding.densityText.setText(element.density.toString());
        } else {
            binding.densityText.setText("-");
        }

        if (element.boil != null) {
            binding.boilText.setText(element.boil.toString());
        } else {
            binding.boilText.setText("-");
        }

        if (element.melt != null) {
            binding.meltText.setText(element.melt.toString());
        } else {
            binding.meltText.setText("-");
        }

        if (element.phase != null) {
            holder = element.phase.substring(0, 1).toUpperCase() + element.phase.substring(1);
            binding.phaseText.setText(holder);
        } else {
            binding.meltText.setText("-");
        }

        binding.descriptionText.setText(element.summary);

        ViewPagerAdapter adapter = new ViewPagerAdapter(ElementImages.getImagesByAtomicNumber(element.number));
        binding.viewPager.setAdapter(adapter);

        binding.imageButton.setOnClickListener(v -> {
            String url = element.source;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }
}
