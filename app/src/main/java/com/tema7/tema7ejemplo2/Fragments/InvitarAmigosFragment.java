package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class InvitarAmigosFragment extends Fragment {


    private FloatingActionButton btnEmail;
    private TextView miEmail;
    private EditText nuevoEmail;
    private AlertDialog.Builder builder;
    EditText etTo;
    FloatingActionButton btnenviar;
    String sEmail, sPassword, mensaje, asunto;
    private FloatingActionButton botonenviarEmail;
    public InvitarAmigosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invitar_amigos, container, false);
        etTo = view.findViewById(R.id.et_para);
        btnenviar = view.findViewById(R.id.botonInvitar);

        sEmail="tfggymt@gmail.com";
        sPassword="tfggymifp12";
        mensaje = "Vaya... Esto es un poco incomodo... Parace que un amigo quiere que " +
                "entrenes un poco y te ha invitado" +
                " a que te vengas con nostros... \nPues ya sabes simplemente buscanos en google play :D\n" +
                "Un abrazo muy fuerte y mucho training.\n" +
                "Att: Equipo de GymTogether.";
        asunto = "Un amigo quiere que te vengas a entrenar GymTogether";
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });


                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(sEmail));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(etTo.getText().toString().trim()));
                    message.setSubject(asunto.toString().trim());
                    message.setText(mensaje.toString().trim());
                    new SendMail1().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    private class SendMail1 extends AsyncTask<Message, String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(),
                    "please wait", "Sending Mail...", true, false);

        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if(s.equals("Success")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setMessage("Mail send successfully.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etTo.setText("");
                    }
                });
                builder.show();
            }else{
                Toast.makeText(getActivity(),
                        "Something went wrong ?", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}