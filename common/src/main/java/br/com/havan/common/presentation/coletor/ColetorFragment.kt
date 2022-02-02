package br.com.havan.common.presentation.coletor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.havan.common.databinding.FragmentColetorBinding

class ColetorFragment : Fragment() {

    val args: ColetorFragmentArgs by navArgs()

    private var _binding: FragmentColetorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColetorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userCode.text = args.codigo
    }
}