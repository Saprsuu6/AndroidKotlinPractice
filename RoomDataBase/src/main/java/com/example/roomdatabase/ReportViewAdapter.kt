package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.ReportViewItemBinding

class ReportViewAdapter : RecyclerView.Adapter<ReportViewAdapter.ViewReport>() {
    class ViewReport(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ReportViewItemBinding.bind(item)

        fun bind(report: Report) {
            // TODO set report
        }
    }

    private val reports: MutableList<Report> = mutableListOf()

    fun addReport(report: Report) {
        reports.add(report)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewReport {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.report_view_item, parent, false)
        return ViewReport(view)
    }

    override fun getItemCount(): Int {
        return reports.size
    }

    override fun onBindViewHolder(holder: ViewReport, position: Int) {
        holder.bind(reports[position])
    }
}