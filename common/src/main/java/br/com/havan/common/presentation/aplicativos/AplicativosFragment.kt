package br.com.havan.common.presentation.aplicativos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.havan.common.databinding.FragmentAplicativosBinding

class AplicativosFragment : Fragment() {

    private var _binding: FragmentAplicativosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAplicativosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AplicativosAdapter { aplicativo -> aplicativoOnClick(aplicativo) }
        binding.aplicativosRecyclerview.adapter = adapter
    }

    private fun aplicativoOnClick(aplicativo: AplicativoModel) {
        val action = AplicativosFragmentDirections.actionAplicativosFragmentToColetorFragment(aplicativo)
        findNavController().navigate(action)
    }
}