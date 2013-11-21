class MessagesController < ApplicationController

  def index
  end

  def show
    @staff = Staff.find(params[:id])
  end

end
