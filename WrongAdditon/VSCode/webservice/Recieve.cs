using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace webservice
{
    public class Recieve
    {
        public string JsonString {get;set;}
        public interface IEndPointRouterBuilder
        {
            
        }
        public static void Main2(string[] args)
        {
            CreateHostBuilder2(args).Build().Run();
        }
        public static IHostBuilder CreateHostBuilder2(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}