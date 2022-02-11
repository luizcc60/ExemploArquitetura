package br.com.havan.common.presentation.aplicativos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.havan.common.R
import br.com.havan.common.databinding.AplicativosLayoutBinding

class AplicativosAdapter(private val onClick: (AplicativoModel) -> Unit): RecyclerView.Adapter<AplicativosAdapter.ViewHolder>() {

    private val aplicativos: MutableList<AplicativoModel> = mutableListOf(
        AplicativoModel("Abastecimento", R.drawable.abastecimento),
        AplicativoModel("Picking", R.drawable.picking))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = AplicativosLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paymentBean: AplicativoModel = aplicativos[position]
        holder.bind(paymentBean)
    }

    override fun getItemCount() = aplicativos.size

    class ViewHolder(
        private val itemBinding: AplicativosLayoutBinding,
        private val onClick: (AplicativoModel) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(aplicativo: AplicativoModel) {
            itemBinding.aplicativoNome.text = aplicativo.nome
            itemBinding.aplicativoImagem.setImageResource(aplicativo.imagem)
            itemBinding.root.setOnClickListener { onClick(aplicativo) }
        }
    }
}