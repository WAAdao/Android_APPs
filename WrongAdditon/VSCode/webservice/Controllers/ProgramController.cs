using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using MySql.Data.MySqlClient;

namespace webservice.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ProgramController : ControllerBase
    {
       public string ConnectionString{get; set;} 
        [HttpGet]
        public Array run()
        {           
           MySql.Data.MySqlClient.MySqlConnection con = new MySql.Data.MySqlClient.MySqlConnection("Server=localhost;Port=3306;Database=test;Uid=user;pwd=root");
           con.Open();
           MySqlCommand com = new MySqlCommand("SELECT valor1, valor2 FROM test.teste2 WHERE valor1='1';");
           com.Connection =  con;
           MySql.Data.MySqlClient.MySqlDataReader read = com.ExecuteReader();          
           read.Read();
           string[] ret = {read.GetString("valor1"), read.GetString("valor2"), "3", "4", "5", "6"};
           con.Close();
           return ret;        
        }

    }
}