package br.com.havan.common.presentation

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.havan.common.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModel()

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configProgressDialog()
        autenticar()
        autenticacaoObserver()
        exceptionObserver()
        loadingObserver()
    }

    private fun configProgressDialog() {
        progressDialog = ProgressDialog(requireActivity())
        progressDialog?.setTitle("Carregando...")
        progressDialog?.setMessage("Aguarde a autenticação")
        progressDialog?.setCancelable(false)
    }

    private fun autenticar() {
        binding.login.setOnClickListener {
            val codigo = binding.inputUser.editText?.text.toString()
            val senha = binding.inputPassword.editText?.text.toString()
            loginViewModel.autenticar(codigo, senha)
        }
    }

    private fun autenticacaoObserver() {
        loginViewModel.autenticacaoViewState.observe(viewLifecycleOwner) {

        }
    }

    private fun exceptionObserver() {
        loginViewModel.exceptionViewState.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadingObserver() {
        loginViewModel.isLoadingViewState.observe(viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }
    }

    private fun showProgressBar() {
        progressDialog?.show()
    }

    private fun hideProgressBar() {
        progressDialog?.dismiss()
    }
}